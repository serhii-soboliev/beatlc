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
        if(!accounts.contains(account1) || !accounts.contains(account2)) return false
        if(accounts(account1) < money) return false
        accounts(account1) = accounts(account1) - money
        accounts(account2) = accounts(account2) + money
        true
    }

    def deposit(account: Int, money: Long): Boolean = {
        if(!accounts.contains(account)) return false
        accounts(account) = accounts(account) + money
        true
    }

    def withdraw(account: Int, money: Long): Boolean = {
        if(!accounts.contains(account)) return false
        if(accounts(account) < money) return false
        accounts(account) = accounts(account) - money
        true
    }


}
