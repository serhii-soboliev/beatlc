package org.sbk.leet
package linkedlist

import utils.ListNode

import scala.annotation.tailrec

/*
1721. Swapping Nodes in a Linked List
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
class SwappingNodesInLinkedList {

    def swapNodes(head: ListNode, k: Int): ListNode = {
        def findLength(head: ListNode): Int = {
            if(head == null) return 0
            1 + findLength(head.next)
        }
        @tailrec
        def findKthElement(head: ListNode, k: Int): ListNode = {
            if(k == 1) return head
            findKthElement(head.next, k-1)

        }
        val n = findLength(head)
        val l = n - k + 1
        val first = findKthElement(head, k)
        val second = findKthElement(head, l)
        val x = first.x
        first.x = second.x
        second.x = x
        head
    }

}
