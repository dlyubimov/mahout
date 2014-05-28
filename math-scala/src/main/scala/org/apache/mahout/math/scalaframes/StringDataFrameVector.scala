package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe


abstract class StringDataFrameVector extends DataFrameVectorLike[String] {
	var data:Unsafe=_
	
}
