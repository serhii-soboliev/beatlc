package org.sbk.leet
package bfs

/*
127. Word Ladder
https://leetcode.com/problems/word-ladder/
 */
class WordLadder {

    def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {

        import scala.collection.mutable
        import scala.collection.mutable.ArrayBuffer

        def isNeighbour(s1: String, s2: String): Boolean = s1.zip(s2).count{case(c1, c2) => c1 != c2} == 1

        val neighbourLookup = (beginWord :: wordList).map(s => s -> wordList.filter(t => isNeighbour(s, t))).toMap

        val visited = mutable.HashSet[String]()
        val q = mutable.Queue[ArrayBuffer[String]](ArrayBuffer(beginWord))
        var mutationsCount = 1
        while(q.nonEmpty) {
            val c = q.dequeue()
            val newQ = ArrayBuffer[String]()
            for(w <- c; if !visited.contains(w)) {
                if(w == endWord) return mutationsCount
                visited += w
                newQ ++= neighbourLookup(w)
            }
            if(newQ.isEmpty) return 0
            mutationsCount += 1
            q += newQ
        }
        mutationsCount
    }

}


object WordLadder {

    def main(args: Array[String]): Unit = {
        val w = new WordLadder()
        println(w.ladderLength(beginWord = "hit", endWord = "cog", wordList = List("hot","dot","dog","lot","log","cog")))
        println(w.ladderLength(beginWord = "hit", endWord = "cog", wordList = List("hot","dot","dog","lot","log")))
    }

}