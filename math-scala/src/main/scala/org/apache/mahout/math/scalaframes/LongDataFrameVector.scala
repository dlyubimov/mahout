package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Long


class LongDataFrameVector(vectorOfLongs:Vector[Long]) extends DataFrameIteratorLike[Long] {
	var data:Unsafe=_
	var curPosition:Int=0
	def apply(x:Int): Long = {
	  return vectorOfLongs.apply(x)
	}
	
	//stub these out for now
	def hasNext: Boolean = {
	  return true;
	}
	
	//stub this to return the current position
	//will need to figure meaning of current position
	def next: Long = {
	  return vectorOfLongs.apply(curPosition);
	}
   
		
}
