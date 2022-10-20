package com.example.linkedlist

import org.w3c.dom.Node
import java.util.*

fun main() {
    val linkedList = LinkedList()

    for (i in 1..5) {
        linkedList.addAll(i)
    }

    linkedList.addAt(2,10)
    linkedList.delete(1)
    linkedList.deleteAt(0)

    linkedList.printAll()
}

class LinkedList {
    private var head: Node? = null
    var size: Int = 0
    private var tail: Node? = null

    inner class Node {
        var next: Node? = null
        var item: Int? = null
    }

    private fun addFirst(item: Int) {
        val newNode = Node().apply {
            this.item = item
            this.next = head
        }
        head = newNode
        if (head?.next == null) {
            tail = head
        }
        size++
    }

    private fun find(index: Int): Node? {
        var node = head
        for (i in 0 until index) {
            node = node?.next
        }
        return node
    }

    fun addAt(index: Int, item: Int) {
        val newNode = Node().apply {
            this.item = item
        }
        val node = find(index)!!
        val temp = node.next
        newNode.next = temp
        node.next = newNode

        if (newNode.next == null){
            tail = newNode
        }
        size++
    }

    fun addAll(item: Int) {
        if (size == 0) {
            addFirst(item)
        } else {
            val newNode = Node().apply {
                this.item = item
            }
            tail?.next = newNode
            tail = newNode
            size++
        }
    }

    fun delete(item: Int) {
        if (head == null) return println("노드가 존재하지 않습니다.")
        else {
            if (head?.item == item) {
                head = head?.next
            } else {
                var node = head
                while (node?.next?.item != item) node = node?.next
                node.next = node.next?.next
            }
        }
    }

    private fun removeFirst(): Int {
        val node = head
        head = node?.next
        size--
        return node?.item!!
    }

    fun deleteAt(index : Int): Int{
        if (index > size - 1) {
            error("invalid position")
        }

        return if (index == 0) {
            removeFirst()
        } else {
            val node = find(index - 1)
            val deletedNode = node?.next
            node?.next = node?.next?.next
            size--
            deletedNode?.item!!
        }
    }

    fun printAll() {
        var node = head
        while (node != null) {
            print("${node.item} ")
            node = node.next
        }
    }

}