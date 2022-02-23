package org.sbk.leet
package design

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class BankSpec extends AnyFlatSpec with Matchers {

    "Bank" should "scenario 1" in {
        val bank = new Bank(Array(10, 100, 20, 50, 30))
        bank.withdraw(3, 10) should be (true)
        bank.transfer(5, 1, 20) should be (true)
        bank.deposit(5, 20) should be (true)
        bank.transfer(3, 4, 15) should be (false)
        bank.withdraw(10, 50) should be (false)
    }

    "Bank" should "scenario 2" in {
        val bank = new Bank(Array(0))
        bank.deposit(1, 2) should be (true)
        bank.transfer(1, 1, 1) should be (true)
        bank.transfer(1, 1, 3) should be (false)
    }
}
