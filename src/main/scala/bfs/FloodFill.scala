package org.sbk.leet
package bfs

/*
733. Flood Fill
https://leetcode.com/problems/flood-fill/
*/

class FloodFill {

    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        val v = image(sr)(sc)
        val n = image.length
        val m = image.headOption.get.length

        def fillColor(i: Int, j: Int) : Unit = {
            if(image(i)(j) != v) return
            image(i)(j) = newColor
            if(i > 0 && image(i-1)(j) != newColor) fillColor(i-1, j)
            if(i < n-1 && image(i+1)(j) != newColor) fillColor(i+1, j)
            if(j > 0 && image(i)(j-1) != newColor) fillColor(i, j-1)
            if(j < m-1 && image(i)(j+1) != newColor) fillColor(i, j+1)
        }
        fillColor(sr, sc)
        image
    }

}
