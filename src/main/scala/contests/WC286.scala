package org.sbk.leet
package contests


class WC286 {

    /*
        2215. Find the Difference of Two Arrays
    */
    def findDifference(nums1: Array[Int], nums2: Array[Int]): List[List[Int]] = {
        import scala.collection.mutable
        val hs1 = mutable.HashSet() ++ nums1
        val hs2 = mutable.HashSet() ++ nums2
        List(hs1.diff(hs2).toList, hs2.diff(hs1).toList)
    }

    /*
        2216. Minimum Deletions to Make Array Beautiful
     */
    def minDeletion(nums: Array[Int]): Int = {
        var d = 0
        val n = nums.length
        (0 until n - 1).foreach(i => {if(((i - d) % 2 == 0) && (nums(i) == nums(i+1))) d += 1})
        if((n - d) % 2 == 1) d +=1
        d
    }

    def minDeletion2 (nums: Array[Int]): Int = {
        def minDel: List[Int] => Int = {
            case Nil => 0;
            case _ :: Nil => 1
            case x :: y :: xs => if (x == y) 1 + minDel (y :: xs) else minDel (xs)
        }
        minDel (nums.toList)
    }


    /*
    2217. Find Palindrome With Fixed Length
     */
    def kthPalindrome2(queries: Array[Int], intLength: Int): Array[Long] = {
        val base: Int = Math.pow(10, (intLength + 1) / 2 - 1).toInt
        val end: Int = Math.pow(10,  (intLength + 1) / 2).toInt - 1
        def getIthPalindrome(i: Int): Long = {
            if(base + i - 1 > end) return -1
            val v = (base + i - 1).toString
            val r = if (intLength % 2 == 0) v.reverse else v.reverse.takeRight(v.length - 1)
            val s = v + r
            s.toLong
        }
        queries.map{i => getIthPalindrome(i)}
    }

    def kthPalindrome (queries: Array[Int], intLength: Int): Array[Long] = {
        val begin = Math.pow(10, (intLength + 1) / 2 - 1).toInt
        queries map (n => if (n > begin * 9) -1 else (begin + n - 1).toString match {
            case str => (str.dropRight (intLength & 1) ++ str.reverse).toLong
        })
    }
}

object WC286 {

    def main(args: Array[String]): Unit = {
        val o = new WC286()
        println(o.kthPalindrome(
            Array(1,2,3,4,5,90), 5
        ).mkString("Array(", ", ", ")"))
    }

}
