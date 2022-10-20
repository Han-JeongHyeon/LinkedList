package com.example.linkedlist

import org.w3c.dom.Node
import java.util.*

fun main() {
    val linkedList = LinkedList<Int>()

    linkedList.add(0)

    for (i in 1..10) {
        linkedList.add(i)
    }
    linkedList.desc()

    linkedList.delete(0)
    linkedList.delete(10)
    linkedList.desc()
}

class LinkedList<E> {
    private var head: Node<E>? = null

    private inner class Node<E>(
        var data: E,
        var next: Node<E>? = null
    )

    private fun addFirst(item: E) {
        head = Node(item)
    }

    fun add(item: E) {
        if (head == null) addFirst(item)
        else {
            var node = head
            while (node?.next != null) node = node.next
            node?.next = Node(item)
        }
    }

    fun delete(item: E) {
        if (head == null) return println("노드가 존재하지 않습니다.")
        else {
            if (head?.data == item) {
                head = head?.next
            } else {
                var node = head
                while (node?.next?.data != item) node = node?.next
                node?.next = node?.next?.next
            }
        }
    }

    fun desc() {
        var node = head
        while (node != null) {
            print("${node.data} ")
            node = node.next
        }
        println()
    }
}