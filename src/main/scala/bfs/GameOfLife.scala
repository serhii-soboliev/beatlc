package org.sbk.leet
package bfs

/*
289. Game of Life
https://leetcode.com/problems/game-of-life/

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */

class GameOfLife {

    def gameOfLife(board: Array[Array[Int]]): Unit = {
        val m = board.length
        val n = board.headOption.get.length

        def isNeighbor(v:(Int, Int)): Boolean ={
            v._1 >= 0 && v._1 < m && v._2 >= 0 && v._2 < n && board(v._1)(v._2) == 1
        }

        def getNeighbors(i: Int, j: Int): Array[(Int, Int)] = {
            val dirs = Array((-1,-1), (0, -1), (1, -1), (-1,0), (1,0), (-1,1), (0,1), (1,1))
            dirs.map(d => (i + d._1, j + d._2)).filter(v => isNeighbor(v))
        }

        val res = board.map(_.clone)
        for {i <- 0 until m; j <- 0 until n} {
            val neiCnt = getNeighbors(i, j).length
            if(board(i)(j) == 0 && neiCnt == 3) res(i)(j) = 1
            if(board(i)(j) == 1 && (3 < neiCnt || neiCnt < 2)) res(i)(j) = 0
        }
        for {i <- 0 until m; j <- 0 until n} board(i)(j) = res(i)(j)
    }

}

object GameOfLife {
    def main(args: Array[String]): Unit = {
        new GameOfLife().gameOfLife(
            Array(Array(0,1,0),
                  Array(0,0,1),
                  Array(1,1,1),
                  Array(0,0,0)))
    }

}
