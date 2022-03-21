package org.sbk.leet
package utils

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {

    def this(_value:  Int) {
        this(_value, null, null)
    }

    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}