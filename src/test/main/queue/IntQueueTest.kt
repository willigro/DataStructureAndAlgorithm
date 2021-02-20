package main.queue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IntQueueTest{
    @Test
    fun `size from new list`() {
        assertEquals(0, IntQueue(1).size())
    }

    @Test
    fun `size after add and remove items`() {
        IntQueue(1).also { queue ->
            assertEquals(0, queue.size())

            // need check if is not empty after call this
            queue.dequeue()

            assertEquals(1, queue.size())
        }
    }

    @Test
    fun isEmpty() {
        assertTrue(IntQueue(1).isEmpty())
    }

    @Test
    fun poll() {
        val queue = IntQueue(5)

        for (i in 0 until 5){
            queue.enqueue(i)
        }

        assertEquals(5, queue.size())

        queue.dequeue()
        assertEquals(4, queue.size())

        queue.dequeue()
        assertEquals(3, queue.size())

        queue.dequeue()
        assertEquals(2, queue.size())

        queue.dequeue()
        assertEquals(1, queue.size())
    }

    @Test
    fun peak() {
        val queue = IntQueue(5)

        for (i in 0 until 5){
            queue.enqueue(i)
        }

        assertEquals(0, queue.peek())
    }

    @Test
    fun offer() {
        val queue = IntQueue(2)

        queue.enqueue(2)
        assertEquals(2, queue.peek())
        assertEquals(1, queue.size())

        queue.enqueue(3)
        assertEquals(2, queue.peek())
        assertEquals(2, queue.size())
    }
}