package org.sbk.leet
package design

import scala.collection.mutable
class StreamChecker(_words: Array[String]) {

    val trie = new MyTrieNode
    val stream: mutable.ArrayDeque[Char] = mutable.ArrayDeque[Char]()
    val max: Int = _words.max.length+1

    for(word <- _words) {
        var node = trie
        for(ch <- word.reverse) {
            if(!node.children.contains(ch))
                node.children.put(ch, new MyTrieNode)
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

case class MyTrieNode(children: mutable.Map[Char, MyTrieNode] = mutable.Map[Char, MyTrieNode](), var word: Boolean = false )
