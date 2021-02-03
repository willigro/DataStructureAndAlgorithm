package main.array

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

/**
 * - capacity
 * - add and increase the capacity
 * - add and increase the capacity, two
 * - trows IndexOutOfBounds on remove
 * - remove by index
 * - remove by element
 * - contains element
 * - indexOf
 * */
internal class DynamicArrayTest {

    @Test
    fun `start array with capacity equals to 10, check the length and if all items are null`() {
        // prepare array
        val arr = DynamicArray<Int>(10)

        // todo: testing
        assertEquals(0, arr.size())
        for (i in 0 until arr.size()) {
            assertNull(arr.get(i))
        }
    }

    @Test
    fun `start array with the capacity equals to 5 and add 6 items`() {
        // amount of items to add
        val items = 6

        // prepare the array
        val arr = DynamicArray<Int>(5)

        // todo: testing
        // all items need be null
        assertEquals(0, arr.size())
        for (i in 0 until arr.size()) {
            assertNull(arr.get(i))
        }

        // add items
        for (i in 0 until items) {
            arr.add(i)
        }

        // checking the items value
        assertEquals(items, arr.size())
        for (i in 0 until arr.size()) {
            assertEquals(i, arr.get(i))
        }
    }

    @Test
    fun `start array with the capacity equals to 2 and add 3 times more twice`() {
        // prepare the array
        val capacity = 2
        val arr = DynamicArray<Int>(capacity)

        // todo: testing
        // add items
        val first = capacity * 3
        for (i in 0 until first) {
            arr.add(i)
        }

        // checking the items value
        assertEquals(first, arr.size())
        for (i in 0 until arr.size()) {
            assertEquals(i, arr.get(i))
        }

        // add more items
        val second = first * 3
        for (i in 0 until second) {
            arr.add(i + first)
        }

        // checking the items value
        assertEquals(second + first, arr.size())
        for (i in 0 until arr.size()) {
            assertEquals(i, arr.get(i))
        }
    }

    @Test
    fun `trows IndexOutOfBounds when to try remove using a index greater than capacity`() {
        // prepare the array
        val arr = DynamicArray<Int>(5)

        // todo: testing
        assertThrows(IndexOutOfBoundsException::class.java) {
            arr.removeAt(10)
        }
    }

    @Test
    fun `remove items from multiple positions`() {
        // prepare the array
        val arr = DynamicArray<Int>(10)

        // add items
        for (i in 0 until 10) {
            arr.add(i)
        }

        // todo: testing
        assertEquals(9, arr.removeAt(9))
        assertEquals(0, arr.removeAt(0))
        assertEquals(5, arr.removeAt(4))
        assertEquals(7, arr.removeAt(5))
    }

    @Test
    fun `remove items by element`() {
        // prepare the array
        val arr = DynamicArray<Int>(10)

        // todo: testing
        // add items
        for (i in 0 until 10) {
            arr.add(i)
        }

        // remove all items
        for (i in 0 until 10) {
            assertTrue(arr.remove(i))
        }

        // try remove all items, but the list is empty
        for (i in 0 until 10) {
            assertFalse(arr.remove(i))
        }
    }

    @Test
    fun `contains element`() {
        // prepare the array
        val arr = DynamicArray<Int>(10)

        // add items
        for (i in 0 until 10) {
            arr.add(i)
        }

        // todo: testing
        assertTrue(arr.contains(5))
        assertFalse(arr.contains(20))
    }

    @Test
    fun `indexOf from elements`() {
        // prepare the array
        val arr = DynamicArray<Int>(10)

        // add items
        for (i in 0 until 10) {
            arr.add(i)
        }

        // todo: testing
        assertEquals(5, arr.indexOf(5))
        assertEquals(2, arr.indexOf(2))
        assertEquals(-1, arr.indexOf(50))
    }
}