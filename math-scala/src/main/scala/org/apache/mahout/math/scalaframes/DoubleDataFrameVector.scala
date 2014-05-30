package org.apache.mahout.math.scalaframes

import scala.concurrent.util.Unsafe
import scala.Double


class DoubleDataFrameVector extends DataFrameVectorLike[Double] {
	var data:Unsafe=_
	var genIterable:scala.collection.GenIterable=_
	var genTraversable:scala.collection.GenTraversable=_
	var theHeadOfVector:Double=_
	var vectorOfDouble:Vector[Double]=_
	var seqDouble:Seq[Double]=_
	
	def sameElements[A1 >: Double](that: scala.collection.GenIterable[A1]): Boolean = {
	  return true
	}
	
   	def zip[A1 >: Double, B, That](that: scala.collection.GenIterable[B])(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],(A1, B),That]): That = {
		return genIterable
   	}
   	
   	def zipAll[B, A1 >: Double, That](that: scala.collection.GenIterable[B],thisElem: A1,thatElem: B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],(A1, B),That]): That = {
   	  
   	}
   	
   	def zipWithIndex[A1 >: Double, That](implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],(A1, Int),That]): That = {
   	
   	}
   	
   // Members declared in scala.collection.GenSeq
   def seq: Seq[Double] = {
     return seqDouble
   }
   
   // Members declared in scala.collection.GenSeqLike
   def :+[B >: Double, That](elem: B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def +:[B >: Double, That](elem: B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }   
   
   def apply(idx: Int): Double = {
     get(idx)
   }
   
   def corresponds[B](that: scala.collection.GenSeq[B])(p: (Double, B) => Boolean): Boolean = {
   }
   
   
   def diff[B >: Double](that: scala.collection.GenSeq[B]): scala.collection.GenSeq[Double] = {
   }
   
   def distinct: scala.collection.GenSeq[Double] = {
   }
   
   def endsWith[B](that: scala.collection.GenSeq[B]): Boolean = {
   }
   
   def indexWhere(p: Double => Boolean,from: Int): Int = {
   }
   
   
   def intersect[B >: Double](that: scala.collection.GenSeq[B]): scala.collection.GenSeq[Double] = {
   }
   
   def lastIndexWhere(p: Double => Boolean,end: Int): Int = {
   }  
   
   def length: Int = {
     
   }
   
   def padTo[B >: Double, That](len: Int,elem: B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def patch[B >: Double, That](from: Int,patch: scala.collection.GenSeq[B],replaced: Int)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def reverse: scala.collection.GenSeq[Double] = {
   }
   
   def reverseMap[B, That](f: Double => B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def segmentLength(p: Double => Boolean,from: Int): Int = {
   }
   
   def startsWith[B](that: scala.collection.GenSeq[B],offset: Int): Boolean = {
   }
   
   def toSeq: scala.collection.GenSeq[Double] = {
   }
   
   def updated[B >: Double, That](index: Int,elem: B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   
   // Members declared in scala.collection.GenTraversableLike
   def ++[B >: Double, That](that: scala.collection.GenTraversableOnce[B])(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def collect[B, That](pf: PartialFunction[Double,B])(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def drop(n: Int): scala.collection.GenSeq[Double] = {
   }
   
   def dropWhile(pred: Double => Boolean): scala.collection.GenSeq[Double] = {
   }
   
   def filter(pred: Double => Boolean): scala.collection.GenSeq[Double] = {
   }
   
   def filterNot(pred: Double => Boolean): scala.collection.GenSeq[Double] = {
   }
   
   def flatMap[B, That](f: Double => scala.collection.GenTraversableOnce[B])(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def groupBy[K](f: Double => K): scala.collection.GenMap[K,scala.collection.GenSeq[Double]] = {
   }
   
   def headOption: Option[Double] = {
   }
   
   def init: scala.collection.GenSeq[Double] = {
   }
   
   def isTraversableAgain: Boolean = {
   }
   
   def last: Double = {
   }
   
   def lastOption: Option[Double] = {
   }
   
   def map[B, That](f: Double => B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def partition(pred: Double => Boolean): (scala.collection.GenSeq[Double], scala.collection.GenSeq[Double]) = {
   }
   
   def repr: scala.collection.GenSeq[Double] = {
   }
   
   def scan[B >: Double, That](z: B)(op: (B, B) => B)(implicit cbf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def scanLeft[B, That](z: B)(op: (B, Double) => B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def scanRight[B, That](z: B)(op: (Double, B) => B)(implicit bf: scala.collection.generic.CanBuildFrom[scala.collection.GenSeq[Double],B,That]): That = {
   }
   
   def size: Int = {
   }
   
   def slice(unc_from: Int,unc_until: Int): scala.collection.GenSeq[Double] = {
   }
   
   def span(pred: Double => Boolean): (scala.collection.GenSeq[Double], scala.collection.GenSeq[Double]) = {
   }
   
   def splitAt(n: Int): (scala.collection.GenSeq[Double], scala.collection.GenSeq[Double]) = {
   }
   
   def stringPrefix: String = {
   }
   
   def tail: scala.collection.GenSeq[Double] = {
   }
   
   def take(n: Int): scala.collection.GenSeq[Double] = {
   }
   
   def takeWhile(pred: Double => Boolean): scala.collection.GenSeq[Double] = {
   }
   
   // Members declared in scala.collection.GenTraversableOnce
   def :\[B](z: B)(op: (Double, B) => B): B = {
   }
   
   def /:[B](z: B)(op: (B, Double) => B): B = {
   }
   
   def aggregate[B](z: B)(seqop: (B, Double) => B,combop: (B, B) => B): B = {
   }
   
   def copyToArray[B >: Double](xs: Array[B],start: Int,len: Int): Unit = {
   }
   
   def copyToArray[B >: Double](xs: Array[B],start: Int): Unit = {
   }
   
   def copyToArray[B >: Double](xs: Array[B]): Unit = {
   }
   
   def count(p: Double => Boolean): Int = {
   }
   
   def exists(pred: Double => Boolean): Boolean = {
   }
   
   def find(pred: Double => Boolean): Option[Double] = {
   }
   
   def fold[A1 >: Double](z: A1)(op: (A1, A1) => A1): A1 = {
   }
   
   def foldLeft[B](z: B)(op: (B, Double) => B): B = {
   }
   
   def foldRight[B](z: B)(op: (Double, B) => B): B = {
   }
   
   def forall(pred: Double => Boolean): Boolean = {
   }
   
   def hasDefiniteSize: Boolean = {
   }
   
   def max[A1 >: Double](implicit ord: Ordering[A1]): Double = {  
   }
   
   def maxBy[B](f: Double => B)(implicit cmp: Ordering[B]): Double = {
   }
   
   def min[A1 >: Double](implicit ord: Ordering[A1]): Double = {
   }
   
   def minBy[B](f: Double => B)(implicit cmp: Ordering[B]): Double = {
   }
   
   def mkString: String = {
   }
   
   def mkString(sep: String): String = {
   }
   
   def mkString(start: String,sep: String,end: String): String = {
   }
   
   def nonEmpty: Boolean = {
   }
   
   def product[A1 >: Double](implicit num: Numeric[A1]): A1 = {
   }
   
   def reduce[A1 >: Double](op: (A1, A1) => A1): A1 = {
   }
   
   def reduceLeftOption[B >: Double](op: (B, Double) => B): Option[B] = {
   }
   
   def reduceOption[A1 >: Double](op: (A1, A1) => A1): Option[A1] = {
   }
   
   def reduceRight[B >: Double](op: (Double, B) => B): B = {
   }
   
   def reduceRightOption[B >: Double](op: (Double, B) => B): Option[B] = {
   }
   
   def sum[A1 >: Double](implicit num: Numeric[A1]): A1 = {
   }
   
   def to[Col[_]](implicit cbf: scala.collection.generic.CanBuildFrom[Nothing,Double,Col[Double]]): Col[Double] = {
   }
   
   def toArray[A1 >: Double](implicit evidence$1: scala.reflect.ClassTag[A1]): Array[A1] = {
   }
   
   def toBuffer[A1 >: Double]: scala.collection.mutable.Buffer[A1] = {
   }
   
   def toIndexedSeq: scala.collection.immutable.IndexedSeq[Double] = {
   }
   
   def toIterable: scala.collection.GenIterable[Double] = {
   }
   
   def toIterator: Iterator[Double] = {
   }
   
   def toList: List[Double] = {
   }
   
   def toMap[K, V](implicit ev: <:<[Double,(K, V)]): scala.collection.GenMap[K,V] = {
   }
   
   def toSet[A1 >: Double]: scala.collection.GenSet[A1] = {
   }
   
   def toStream: Stream[Double] = {
   }
   
   def toTraversable: scala.collection.GenTraversable[Double] = {
   }
   
   def toVector: Vector[Double] = {
     return vectorOfDouble
   }
   
   // Members declared in scala.collection.generic.GenericTraversableTemplate
   def foreach[U](f: Double => U): Unit = {
   }
   
   def head: Double = {
     return theHeadOfVector;
   }
   
   def isEmpty: Boolean = {
     return true;
   } 
   
   // Members declared in scala.collection.Parallelizable
   protected[this] def parCombiner: scala.collection.parallel.Combiner[Double,scala.collection.parallel.ParSeq[Double]] = {
   }
   
		
}
