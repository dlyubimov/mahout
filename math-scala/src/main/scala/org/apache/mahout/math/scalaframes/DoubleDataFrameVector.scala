package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Double


abstract class DoubleDataFrameVector extends DataFrameVectorLike[Double] {
	var data:Unsafe=_
	
}
