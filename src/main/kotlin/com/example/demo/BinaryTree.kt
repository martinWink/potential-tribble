package com.example.demo

class BinaryTree {

    var root: Node? = null

    fun insert(value: Int): Boolean {
        val node = Node(value)
        if (this.root == null) {
            this.root = node
        } else {
            var find: Node? = this.root
            while(find != null) {
                if (find.key > value) {
                    if (find.left == null) {
                        find.left = node
                        return true
                    } else {
                        find = find.left
                    }
                } else if (find.key < value) {
                    if (find.right == null) {
                        find.right = node
                        return true
                    } else {
                        find = find.right
                    }
                } else {
                    return false
                }
            }
        }
        return false
    }
}