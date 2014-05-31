package org.apache.mahout.math.scalaframes

import scala.collection.Iterator

trait DataFrameIteratorLike[T] extends Iterator[T]{
  def apply(x:Int): T
}