package org.sbk.leet
package bfs

/*
733. Flood Fill
https://leetcode.com/problems/flood-fill/
*/

class FloodFill {

    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        import scala.collection.mutable.ArrayBuffer

        val v = image(sr)(sc)
        if(v == newColor) return image

        def fillColor(i: Int, j: Int): Unit = {
            image(i)(j) = newColor
            getNeighbors(i, j)
              .filter{case(k,l) => image(k)(l) == v}
              .foreach{case(k,l) => fillColor(k,l)}
        }

        def getNeighbors(i: Int, j:Int): Array[(Int, Int)] = {
            val res = new ArrayBuffer[(Int, Int)]
            if(i > 0) res.addOne(i-1, j)
            if(i < image.length-1) res.addOne(i+1, j)
            if(j > 0) res.addOne(i, j-1)
            if(j < image.headOption.get.length-1) res.addOne(i, j+1)
            res.toArray
        }

        fillColor(sr, sc)
        image
    }

}
