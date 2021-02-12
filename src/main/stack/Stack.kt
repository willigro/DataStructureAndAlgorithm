package main.stack

import java.util.*

class Stack<T>(firstElement: T?) : Iterable<T> {

    private val list = LinkedList<T>()

    init {
        list.push(firstElement)
    }

    fun size() = list.size

    fun isEmpty() = size() == 0

    fun push(elm: T?) {
        list.addLast(elm)
    }

    fun pop(): T? {
        if (isEmpty()) throw EmptyStackException()
        return list.removeLast()
    }

    fun peek(): T {
        if (isEmpty()) throw EmptyStackException()
        return list.peekLast()
    }

    override fun iterator(): Iterator<T> {
        return list.iterator()
    }
}