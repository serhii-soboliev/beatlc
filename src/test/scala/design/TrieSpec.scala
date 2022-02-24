package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TrieSpec extends AnyFlatSpec with Matchers {

    "TrieSpec" should "scenario 1" in {
        val trie = new Trie(Array("cd", "f", "kl"))
        trie.search("cd") should be (true)
        trie.search("f") should be (true)
        trie.search("kl") should be (true)
        trie.search("nn") should be (false)
        trie.search("kn") should be (false)
        trie.search("") should be (true)
    }
}
