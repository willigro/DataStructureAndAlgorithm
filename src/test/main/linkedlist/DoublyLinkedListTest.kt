package main.linkedlist

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail


internal class DoublyLinkedListTest {

    @Test
    fun `add items, clear the list and check its size`() {
        val list = DoublyLinkedList<Int>()
        for (i in 0 until 10)
            list.add(i)

        assertTrue(list.size() > 0)

        list.clear()

        assertTrue(list.size() == 0)
    }

    @Test
    fun `check if is empty, add a item, clear the list and check again if it is empty`() {
        val list = DoublyLinkedList<Int>()

        assertTrue(list.isEmpty())

        list.add(1)
        list.clear()

        assertTrue(list.isEmpty())
    }

    @Test
    fun `add items to last, check size and peak the last one to check if is right`() {
        val list = DoublyLinkedList<Int>()

        for (i in 0 until 10)
            list.addLast(i)

        assertTrue(list.size() == 10)

        list.addLast(20)

        assertTrue(list.peakLast() == 20)
    }

    @Test
    fun `add items to first, check size and peak the first one to check if is right`() {
        val list = DoublyLinkedList<Int>()

        for (i in 0 until 10)
            list.addFirst(i)

        assertTrue(list.size() == 10)

        list.addFirst(20)

        assertTrue(list.peakFirst() == 20)
    }

    @Test
    fun `add items and remove the first`() {
        val list = DoublyLinkedList<Int>()

        for (i in 0 until 10)
            list.add(i)

        assertTrue(list.size() == 10)

        assertTrue(list.peakFirst() == 0)

        list.removeFirst()

        assertTrue(list.peakFirst() == 1)
    }

    @Test
    fun `add items and remove the last`() {
        val list = DoublyLinkedList<Int>()

        for (i in 0 until 10)
            list.add(i)

        assertTrue(list.size() == 10)

        assertTrue(list.peakLast() == 9)

        list.removeLast()

        assertTrue(list.peakLast() == 8)
    }

    @Test
    fun `add items, remove by data and check if the it still are in the list`() {
        val list = DoublyLinkedList<Int>()

        for (i in 0 until 10)
            list.add(i)

        assertTrue(list.size() == 10)

        val data = 2
        list.remove(data)

        assertTrue(list.size() == 9)

        for (i in list.iterator()) {
            if (i == data) fail()
        }
    }

    @Test
    fun `add items, remove by index and check if the data still are in the list`() {
        val list = DoublyLinkedList<Int>()

        val size = 20
        for (i in 0 until size)
            list.add(i)

        assertEquals(size, list.size())

        val data = list.removeAt(10)

        assertEquals(size - 1, list.size())

        for (i in list.iterator()) {
            if (i == data) fail()
        }
    }

    @Test
    fun `add items and check the index of they`() {
        val list = DoublyLinkedList<Int>()

        val size = 20
        for (i in 0 until size)
            list.add(i)

        assertEquals(0, list.indexOf(0))
        assertEquals(13, list.indexOf(14))
        assertEquals(-1, list.indexOf(20))
    }

    @Test
    fun `add items and check if they are in the list`() {
        val list = DoublyLinkedList<Int>()

        val size = 20
        for (i in 0 until size)
            list.add(i)

        assertTrue(list.contains(0))
        assertTrue(list.contains(19))
        assertFalse(list.contains(20))
    }
}