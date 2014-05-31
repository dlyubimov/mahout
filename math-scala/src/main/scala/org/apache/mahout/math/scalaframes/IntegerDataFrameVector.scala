package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Double


class IntegerDataFrameVector(vectorOfInts:Vector[Int]) extends DataFrameIteratorLike[Int] {
	var data:Unsafe=_
	var curPosition:Int=0
	def apply(x:Int): Int = {
	  return vectorOfInts.apply(x)
	}
	
	//stub these out for now
	def hasNext: Boolean = {
	  return true;
	}
	
	//stub this to return the current position
	//will need to figure meaning of current position
	def next: Int = {
	  return vectorOfInts.apply(curPosition);
	}
   
		
}