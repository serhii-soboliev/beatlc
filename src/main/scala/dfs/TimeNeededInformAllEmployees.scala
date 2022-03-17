package org.sbk.leet
package dfs

/*
1376. Time Needed to Inform All Employees
https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
class TimeNeededInformAllEmployees {

    def numOfMinutes(n: Int, headID: Int, manager: Array[Int], informTime: Array[Int]): Int = {
        import scala.collection.mutable
        import scala.collection.mutable._
        case class Node(value: Int, informTime: Int, children: ListBuffer[Node])

        def buildManagerMap(): mutable.Map[Int, ListBuffer[Int]] = {
            val res = new mutable.HashMap[Int, ListBuffer[Int]]().withDefaultValue(new ListBuffer[Int]())
            manager.zipWithIndex.foreach (v => res(v._1) = res.getOrElse(v._1, new ListBuffer[Int]()) += v._2)
            res
        }

        def buildTree(): Node = {
            val mm = buildManagerMap()
            val head = Node(headID, informTime(headID), new ListBuffer[Node]())
            val q = mutable.Queue(head)
            while(q.nonEmpty) {
                val n = q.dequeue()
                val c = mm(n.value).map(l => Node(l, informTime(l), new ListBuffer[Node]())).toList
                n.children.addAll(c)
                q.addAll(c)
            }
            head
        }

        def findMaxTimeToInform(n: Node): Int = {
            n.informTime + n.children.map(c => findMaxTimeToInform(c)).reduceOption(_ max _).getOrElse(0)
        }

        findMaxTimeToInform(buildTree())
    }

}
