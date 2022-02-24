package org.sbk.leet
package design

import scala.collection.mutable

/*
1032. Stream of Characters
https://leetcode.com/problems/stream-of-characters/
 */
class StreamChecker(_words: Array[String]) {

    def query(letter: Char): Boolean = {
        true
    }

}

class TrieNode() {
    val children = new mutable.HashMap[Char, TrieNode]()
    var isEndOfWord = false

}

class Trie() {

    def this(words: Array[String]) {
        this()
        words foreach(w => { this.insert(w) })
    }

    private val root = new TrieNode()

    def insert(key: String) : Unit = {
        var crawl = root
        key foreach ( c=> {
            if(!crawl.children.contains(c)) crawl.children(c) = new TrieNode()
            crawl = crawl.children(c)
        })
        crawl.isEndOfWord = true
    }

    def search(key: String) : Boolean = {
        var crawl = root
        key foreach( c=> {
            if(!crawl.children.contains(c)) return false
            crawl = crawl.children(c)
        })
        true
    }
}



/*
case class Trie[V](value: Option[V], children: List[Option[Trie[V]]]) {
    def insert(key: String, value: V): Trie[V] = Trie.insert(this, key, value, 0)

    def delete(key: String): Trie[V] = Trie.delete(this, key, 0)

    def search(key: String): Option[V] = Trie.search(this, key, 0)
}

object Trie {
    def empty[V]: Trie[V] = new Trie[V](None, List.fill(26)(None))

    def apply[V]: Trie[V] = empty[V]

    @tailrec
    private def search[V](node: Trie[V], key: String, step: Int): Option[V] =
        if (key.length == step) {
            node.value
        } else {
            node.children(key.charAt(step) - 97) match {
                case Some(nextItem) => search(nextItem, key, step + 1)
                case None           => None
            }
        }

    private def insert[V](node: Trie[V], key: String, value: V, step: Int): Trie[V] =
        if (key.length == step) {
            node.copy(value = Some(value))
        } else {
            val index    = key.charAt(step) - 97
            val nextItem = node.children(index).getOrElse(Trie.empty[V])
            val newNode  = insert(nextItem, key, value, step + 1)
            val newNext  = node.children.updated(index, Some(newNode))

            node.copy(children = newNext)
        }

    private def delete[V](node: Trie[V], key: String, step: Int): Trie[V] =
        if (key.length == step) {
            node.copy(value = None)
        } else {
            val index = key.charAt(step) - 97
            node.children(index) match {
                case None           => node
                case Some(nextItem) =>
                    val newNode     = delete(nextItem, key, step + 1)
                    val newChildren =
                        if (newNode.value.isEmpty && newNode.children.forall(_.isEmpty))
                            node.children.updated(index, None)
                        else
                            node.children.updated(index, Some(newNode))

                    node.copy(children = newChildren)
            }
        }
}

 */
