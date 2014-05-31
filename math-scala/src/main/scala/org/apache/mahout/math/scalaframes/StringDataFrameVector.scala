package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe


class StringDataFrameVector(vectorOfStrings:Vector[String]) extends DataFrameIteratorLike[String] {
	var data:Unsafe=_
	var curPosition:Int=0
	def apply(x:Int): String = {
	  return vectorOfStrings.apply(x)
	}
	
	//stub these out for now
	def hasNext: Boolean = {
	  return true;
	}
	
	//stub this to return the current position
	//will need to figure meaning of current position
	def next: String = {
	  return vectorOfStrings.apply(curPosition);
	}
   
		
}