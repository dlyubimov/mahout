/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.mahout.ga.watchmaker.cd.hadoop;

import java.io.IOException;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.mahout.common.RandomUtils;
import org.apache.mahout.common.RandomWrapper;
import org.apache.mahout.common.StringUtils;

/**
 * Separate the input data into a training and testing set.
 */
public final class DatasetSplit {

  private static final String SEED = "traintest.seed";

  private static final String THRESHOLD = "traintest.threshold";

  private static final String TRAINING = "traintest.training";

  private final long seed;

  private final double threshold;

  private boolean training;

  /**
   * 
   * @param seed
   * @param threshold
   *          fraction of the total dataset that will be used for training
   */
  public DatasetSplit(long seed, double threshold) {
    this.seed = seed;
    this.threshold = threshold;
    this.training = true;
  }

  public DatasetSplit(double threshold) {
    this(((RandomWrapper) RandomUtils.getRandom()).getSeed(), threshold);
  }

  public DatasetSplit(Configuration conf) {
    seed = getSeed(conf);
    threshold = getThreshold(conf);
    training = isTraining(conf);
  }

  public long getSeed() {
    return seed;
  }

  public double getThreshold() {
    return threshold;
  }

  public boolean isTraining() {
    return training;
  }

  public void setTraining(boolean training) {
    this.training = training;
  }

  public void storeJobParameters(Configuration conf) {
    conf.set(SEED, StringUtils.toString(seed));
    conf.set(THRESHOLD, Double.toString(threshold));
    conf.setBoolean(TRAINING, training);
  }

  static long getSeed(Configuration conf) {
    String seedstr = conf.get(SEED);
    if (seedstr == null) {
      throw new IllegalArgumentException("SEED job parameter not found");
    }

    return StringUtils.<Long> fromString(seedstr);
  }

  static double getThreshold(Configuration conf) {
    String thrstr = conf.get(THRESHOLD);
    if (thrstr == null) {
      throw new IllegalArgumentException("THRESHOLD job parameter not found");
    }

    return Double.parseDouble(thrstr);
  }

  static boolean isTraining(Configuration conf) {
    if (conf.get(TRAINING) == null) {
      throw new IllegalArgumentException("TRAINING job parameter not found");
    }

    return conf.getBoolean(TRAINING, true);
  }

  /**
   * a {@link RecordReader} that skips some lines from the
   * input. Uses a Random number generator with a specific seed to decide if a line will be skipped or not.
   */
  public static class RndLineRecordReader extends RecordReader<LongWritable, Text> {

    private final RecordReader<LongWritable, Text> reader;

    private final Random rng;

    private final double threshold;

    private final boolean training;

    private final LongWritable k = new LongWritable();

    private final Text v = new Text();

    public RndLineRecordReader(RecordReader<LongWritable, Text> reader, Configuration conf) {
      if (reader == null) {
        throw new IllegalArgumentException("null reader");
      }

      this.reader = reader;

      DatasetSplit split = new DatasetSplit(conf);

      rng = RandomUtils.getRandom(split.getSeed());
      threshold = split.getThreshold();
      training = split.isTraining();
    }

    @Override
    public void close() throws IOException {
      reader.close();
    }

    @Override
    public float getProgress() throws IOException {
      try {
        return reader.getProgress();
      } catch (InterruptedException e) {
        return 0;
      }
    }

    @Override
    public LongWritable getCurrentKey() throws IOException, InterruptedException {
      return k;
    }

    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
      return v;
    }

    @Override
    public void initialize(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
      reader.initialize(split, context);
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
      boolean read;
      do {
        read = reader.nextKeyValue();
      } while (read && !selected());

      if (!read) {
        return false;
      }

      k.set(reader.getCurrentKey().get());
      v.set(reader.getCurrentValue());
      return true;
    }

    /**
     * 
     * @return true if the current input line is not skipped.
     */
    private boolean selected() {
      return training ? rng.nextDouble() < threshold : rng.nextDouble() >= threshold;
    }

  }

  /**
   * {@link TextInputFormat} that uses a {@link RndLineRecordReader} as a RecordReader
   */
  public static class DatasetTextInputFormat extends TextInputFormat {
    @Override
    public RecordReader<LongWritable, Text> createRecordReader(InputSplit split,
                                                               TaskAttemptContext context) {
      return new RndLineRecordReader(super.createRecordReader(split, context), context.getConfiguration());
    }
  }
}
