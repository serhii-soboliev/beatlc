package org.sbk.leet
package hashtables


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RepeatedDNASequencesSpec extends AnyFlatSpec with Matchers{

    "RepeatedDNASequences.findRepeatedDnaSequences('AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT')" should "be ['AAAAACCCCC','CCCCCAAAAA']" in {
        new RepeatedDNASequences()
          .findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") should contain allOf("AAAAACCCCC", "CCCCCAAAAA")
    }

    "RepeatedDNASequences.findRepeatedDnaSequences('AAAAAAAAAAAAA')" should "be ['AAAAAAAAAAAAA']" in {
        new RepeatedDNASequences()
          .findRepeatedDnaSequences("AAAAAAAAAAAAA") should contain ("AAAAAAAAAA")
    }

    "RepeatedDNASequences.findRepeatedDnaSequences('AAAAAAAAAAA')" should "be ['AAAAAAAAAA']" in {
        new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA") should contain ("AAAAAAAAAA")
    }

    "RepeatedDNASequences.findRepeatedDnaSequencesNaive('AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT')" should "be ['AAAAACCCCC','CCCCCAAAAA']" in {
        new RepeatedDNASequences()
          .findRepeatedDnaSequencesNaive("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") should contain allOf("AAAAACCCCC", "CCCCCAAAAA")
    }

    "RepeatedDNASequences.findRepeatedDnaSequencesNaive('AAAAAAAAAAAAA')" should "be ['AAAAAAAAAAAAA']" in {
        new RepeatedDNASequences()
          .findRepeatedDnaSequencesNaive("AAAAAAAAAAAAA") should contain ("AAAAAAAAAA")
    }

    "RepeatedDNASequences.findRepeatedDnaSequencesNaive('AAAAAAAAAAA')" should "be ['AAAAAAAAAA']" in {
        new RepeatedDNASequences().findRepeatedDnaSequencesNaive("AAAAAAAAAAA") should contain ("AAAAAAAAAA")
    }

}
