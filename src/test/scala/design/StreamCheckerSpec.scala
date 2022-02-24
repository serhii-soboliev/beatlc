package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class StreamCheckerSpec extends AnyFlatSpec with Matchers {

    "StreamChecker" should "scenario 1" in {
        val streamChecker = new StreamCheckerNaive(Array("cd", "f", "kl"))
        streamChecker.query('a') should be (false) // return False
        streamChecker.query('b') should be (false) // return False
        streamChecker.query('c') should be (false) // return False
        streamChecker.query('d') should be (true) // return True, because 'cd' is in the wordlist
        streamChecker.query('e') should be (false) // return False
        streamChecker.query('f') should be (true) // return True, because 'f' is in the wordlist
        streamChecker.query('g') should be (false)  // return False
        streamChecker.query('h') should be (false)  // return False
        streamChecker.query('i') should be (false)  // return False
        streamChecker.query('j') should be (false)  // return False
        streamChecker.query('k') should be (false)  // return False
        streamChecker.query('l') should be (true) // return True, because 'kl' is in the wordlist
    }

}
