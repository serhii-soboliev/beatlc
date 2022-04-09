package org.sbk.leet
package bfs



/*
841. Keys and Rooms
https://leetcode.com/problems/keys-and-rooms/
 */
class KeysAndRooms {

    def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
        import scala.collection.mutable
        val visited = mutable.Set.empty[Int]
        dfs(0, rooms)

        def dfs(node: Int, rooms: List[List[Int]]): Unit = {
            visited += node
            rooms(node).foreach(key => if (!visited.contains(key)) dfs(key, rooms))
        }

        visited.size == rooms.length
    }

}
