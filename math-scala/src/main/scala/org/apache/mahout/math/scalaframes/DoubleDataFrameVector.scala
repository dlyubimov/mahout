package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Double


class DoubleDataFrameVector(vectorOfDoubles:Vector[Double]) extends DataFrameIteratorLike[Double] {
	var data:Unsafe=_
	var curPosition:Int=0
	def apply(x:Int): Double = {
	  return vectorOfDoubles.apply(x)
	}
	
	//stub these out for now
	def hasNext: Boolean = {
	  return true;
	}
	
	//stub this to return the current position
	//will need to figure meaning of current position
	def next: Double = {
	  return vectorOfDoubles.apply(curPosition);
	}
   
		
}
