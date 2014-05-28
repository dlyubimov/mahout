package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Long


abstract class LongDataFrameVector extends DataFrameVectorLike[Long] {
	var data:Unsafe=_
	
}
