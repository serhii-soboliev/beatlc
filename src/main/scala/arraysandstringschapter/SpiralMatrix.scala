package org.sbk.leet
package arraysandstringschapter

/*
54. Spiral Matrix
https://leetcode.com/problems/spiral-matrix/
 */
class SpiralMatrix {

    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        import scala.collection.mutable.ListBuffer
        val res = ListBuffer[Int]()
        var (left, right) = (0, matrix.head.length - 1)
        var (top, down) = (0, matrix.length - 1)

        while (left <= right && top <= down) {
            (left to right) foreach (j => res += matrix(top)(j))
            top += 1
            (top to down) foreach (j => res += matrix(j)(right))
            right -= 1
            if(top <= down) (right to left by -1) foreach (j => res += matrix(down)(j))
            down -= 1
            if (left <= right) (down to top by -1) foreach (j => res += matrix(j)(left))
            left += 1
        }
        res.toList
    }

}
