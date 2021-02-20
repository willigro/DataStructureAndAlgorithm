package main.queue

class IntQueue(maxSize: Int) {

    private var ar: IntArray
    private var front = 0
    private var end: Int = 0
    private var sz: Int = 0

    // maxSize is the maximum number of items
    // that can be in the queue at any given time
    init {
        end = 0
        front = end
        sz = maxSize + 1
        ar = IntArray(sz)
    }

    // Return true/false on whether the queue is empty
    fun isEmpty(): Boolean {
        return front == end
    }

    // Return the number of elements inside the queue
    fun size(): Int {
        return if (front > end) end + sz - front else end - front
    }

    fun peek(): Int {
        return ar[front]
    }

    // Add an element to the queue
    fun enqueue(value: Int) {
        ar[end] = value
        if (++end == sz) end = 0
        if (end == front) throw RuntimeException("Queue too small!")
    }

    // Make sure you check is the queue is not empty before calling dequeue!
    fun dequeue(): Int {
        val retVal = ar[front]
        if (++front == sz) front = 0
        return retVal
    }

}