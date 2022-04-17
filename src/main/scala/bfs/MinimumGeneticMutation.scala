package org.sbk.leet
package bfs


/*
433. Minimum Genetic Mutation
https://leetcode.com/problems/minimum-genetic-mutation/
 */
class MinimumGeneticMutation {

        def minMutation(start: String, end: String, bank: Array[String]): Int = {
            import scala.collection.mutable
            import scala.collection.mutable.ArrayBuffer
            import scala.collection.immutable.HashSet

            def replace(s: String, i: Int, c: Char) : String = {
                val a = s.toCharArray
                a(i) = c
                a.mkString
            }

            val visited = scala.collection.mutable.HashSet[String](start)
            val genes = Array('A', 'C', 'G', 'T')
            val bankSet = HashSet[String]() ++ bank
            val initGeneration = mutable.ArrayBuffer[String](start)
            val generations = mutable.Queue[ArrayBuffer[String]](initGeneration)
            var generationsCount = 0

            while(generations.nonEmpty) {
                val currentGeneration = generations.dequeue()
                val newGeneration = mutable.ArrayBuffer[String]()
                for(specimen <- currentGeneration) {
                    if(specimen == end) return generationsCount
                    for(i <- specimen.indices;gene <- genes; if specimen(i) != gene) {
                        val newSpecimen = replace(specimen, i, gene)
                        if(bankSet.contains(newSpecimen) && !visited.contains(newSpecimen)) {
                            newGeneration += newSpecimen
                            visited += newSpecimen
                        }
                    }
                }
                if(newGeneration.nonEmpty) generations += newGeneration
                generationsCount += 1
            }
            -1
        }

}

object MinimumGeneticMutation {
    def main(args: Array[String]): Unit = {
        val w = new MinimumGeneticMutation()
        println(w.minMutation(start = "AACCGGTT", end = "AACCGGTA", bank = Array("AACCGGTA")))
        println(w.minMutation(start = "AACCGGTT", end = "AAACGGTA", bank = Array("AACCGGTA","AACCGCTA","AAACGGTA")))
        println(w.minMutation(start = "AAAAACCC", end = "AACCCCCC", bank = Array("AAAACCCC","AAACCCCC","AACCCCCC")))
        println(w.minMutation(start = "AACCTTGG", end = "AATTCCGG", bank = Array("AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC")))
        println(w.minMutation(start = "AACCGGTT", end = "AAACGGTA", bank = Array("AACCGATT","AACCGATA","AAACGATA","AAACGGTA")))

    }



}
