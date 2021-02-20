package main.queue

import java.util.LinkedList

class Queue<T>(var elm: T? = null) : Iterable<T?> {
    private val list = LinkedList<T>()

    init {
        elm?.also { offer(elm) }
    }

    fun size() = list.size

    fun isEmpty() = list.size == 0

    fun peak(): T? {
        return list.peekFirst()
    }

    fun poll(): T? {
        return list.removeFirst()
    }

    fun offer(elm: T?) {
        list.addLast(elm)
    }

    override fun iterator(): Iterator<T?> {
        return list.iterator()
    }
}