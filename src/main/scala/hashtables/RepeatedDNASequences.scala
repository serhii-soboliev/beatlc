package org.sbk.leet
package hashtables



/*
187. Repeated DNA Sequences
https://leetcode.com/problems/repeated-dna-sequences/
 */
class RepeatedDNASequences {

    def findRepeatedDnaSequences(s: String): List[String] = {
        s.sliding(10)
          .toList
          .groupBy(identity)
          .view
          .mapValues(_.size)
          .filter(_._2 > 1)
          .keys
          .toList
    }


    def findRepeatedDnaSequencesNaive(s: String): List[String] = {
        import scala.collection.mutable
        if(s.length < 11) return List[String]()
        val seqCnt: mutable.Map[String, Int] = new mutable.HashMap[String, Int]().withDefaultValue(0)
        for(i <- 0 to s.length - 10) {
            val sub = s.slice(i, i+10)
            seqCnt(sub) = seqCnt.getOrElse(sub, 0) + 1
        }
        seqCnt
          .filter{ case(_, v) => v > 1}
          .keySet
          .toList
    }
}
