package org.sbk.leet
package design

import scala.collection.mutable
class StreamChecker(_words: Array[String]) {

    val trie = new TrieNode
    val stream: mutable.ArrayDeque[Char] = mutable.ArrayDeque[Char]()
    val max: Int = _words.max.length+1

    for(word <- _words) {
        var node = trie
        for(ch <- word.reverse) {
            if(!node.children.contains(ch))
                node.children.put(ch, new TrieNode)
            node = node.children(ch)
        }
        node.word = true
    }

    def query(letter: Char): Boolean = {
        if(stream.length > max) stream.removeLast()
        stream.prepend(letter)

        var node = trie
        for(ch <- stream) {
            if(node.word) return true
            if(!node.children.contains(ch)) return false
            node = node.children(ch)
        }
        node.word
    }
}

case class TrieNode(children: mutable.Map[Char, TrieNode] = mutable.Map[Char, TrieNode](), var word: Boolean = false )
