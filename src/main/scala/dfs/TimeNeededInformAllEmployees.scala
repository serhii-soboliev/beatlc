package org.sbk.leet
package dfs

/*
1376. Time Needed to Inform All Employees
https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
class TimeNeededInformAllEmployees {

    def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {

        val mm = manager
          .zipWithIndex
          .groupBy(_._1)
          .view
          .mapValues(_.map(_._2))

        def findMaxTimeToInform(n: Int): Int = {
            informTime(n) + mm.get(n).fold(ifEmpty = 0)(_.map(findMaxTimeToInform).max)
        }

        findMaxTimeToInform(headID)
    }

}
