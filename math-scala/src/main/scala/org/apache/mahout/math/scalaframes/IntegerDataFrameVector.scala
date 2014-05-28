package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Int


abstract class IntegerDataFrameVector extends DataFrameVectorLike[Int] {
	var data:Unsafe=_
	
}
