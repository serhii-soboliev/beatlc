package org.sbk.leet
package design

/*
2043. Simple Bank System
https://leetcode.com/problems/simple-bank-system/
 */
class Bank(balance: Array[Long]) {

    import scala.collection.mutable

    private val accounts: mutable.Map[Int, Long] = balance.zipWithIndex.map{ case(i,j) => (j+1,i)}.to(mutable.Map)

    def transfer(account1: Int, account2: Int, money: Long): Boolean = {
        accounts.get(account1).filter(v1 => v1 >= money).map(_ => {
            accounts.get(account2).map(_ => {
                accounts(account1) -= money
                accounts(account2) += money
                true
            }).orElse(Option(false)).get
        }).orElse(Option(false)).get
    }

    def deposit(account: Int, money: Long): Boolean = {
        accounts.get(account).map(v => {
            accounts(account) = v + money
            true
        }).orElse(Option(false)).get
    }

    def withdraw(account: Int, money: Long): Boolean = {
        accounts.get(account).filter(v => v >= money).map(v => {
            accounts(account) = v - money
            true
        }).orElse(Option(false)).get
    }


}
