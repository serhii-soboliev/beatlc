package org.sbk.leet
package dfs

/*
785. Is Graph Bipartite?
https://leetcode.com/problems/is-graph-bipartite/
 */
class IsGraphBipartite {

    def isBipartite(g: Array[Array[Int]]): Boolean = {

        val colors = Array.fill[Int](g.length)(0)

        def tryToColor(i: Int, color: Int): Boolean = {
            if(colors(i) != 0) return colors(i) == color
            colors(i) = color
            g(i).forall(j => tryToColor(j, -color))
        }

        g.indices.forall(i => colors(i) != 0 || tryToColor(i, 1))
    }
}


object IsGraphBipartite {

    def main(args: Array[String]): Unit = {
        val pb = new IsGraphBipartite()
        println(pb.isBipartite(Array(Array(1,3),Array(0,2),Array(1,3),Array(0,2))))
        println(pb.isBipartite(Array(Array(1,2,3),Array(0,2),Array(0,1,3),Array(0,2))))
    }

}