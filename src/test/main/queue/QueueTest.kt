package main.queue

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QueueTest {

    @Test
    fun `size from new list`() {
        assertEquals(0, Queue<Int>().size())
    }

    @Test
    fun `size after add and remove items`() {
        Queue(1).also { queue ->
            assertEquals(1, queue.size())

            queue.poll()

            assertEquals(0, queue.size())
        }
    }

    @Test
    fun isEmpty() {
        assertTrue(Queue<Int>().isEmpty())
    }

    @Test
    fun poll() {
        val queue = Queue<Int>()

        for (i in 0 until 5){
            queue.offer(i)
        }

        assertEquals(5, queue.size())

        queue.poll()
        assertEquals(4, queue.size())

        queue.poll()
        assertEquals(3, queue.size())

        queue.poll()
        assertEquals(2, queue.size())

        queue.poll()
        assertEquals(1, queue.size())
    }

    @Test
    fun peak() {
        val queue = Queue<Int>()

        for (i in 0 until 5){
            queue.offer(i)
        }

        assertEquals(0, queue.peak())
    }

    @Test
    fun offer() {
        val queue = Queue<Int>()

        queue.offer(2)
        assertEquals(2, queue.peak())
        assertEquals(1, queue.size())

        queue.offer(3)
        assertEquals(2, queue.peak())
        assertEquals(2, queue.size())
    }
}