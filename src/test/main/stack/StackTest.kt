package main.stack

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.util.EmptyStackException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class StackTest {

    @Test
    fun `size from a new list`() {
        val stack = Stack<Int>(null)
        assertEquals(1, stack.size())
    }

    @Test
    fun `size from a list with twenty items`() {
        val stack = Stack<Int>(null)
        for (i in 0 until 19)
            stack.push(i)
        assertEquals(20, stack.size())
    }

    @Test
    fun isEmpty() {
        val stack = Stack<Int>(null)
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun push() {
        val stack = Stack<Int>(null)
        assertEquals(1, stack.size())
        stack.push(2)
    }

    @Test
    fun pop() {
        val stack = Stack<Int>(null)
        assertEquals(1, stack.size())
        stack.push(2)
        assertEquals(2, stack.size())
        stack.pop()
        assertEquals(1, stack.size())
        stack.pop()
        assertEquals(0, stack.size())

    }

    @Test
    fun `throw an exception when the list is empty and pop function is called`() {
        val stack = Stack<Int>(null)
        stack.pop()
        assertThrows(EmptyStackException::class.java) {
            stack.pop()
        }
    }

    @Test
    fun peek() {
        val stack = Stack(5)
        assertEquals(5, stack.peek())
        stack.push(2)
        assertEquals(2, stack.peek())
        stack.pop()
        assertEquals(5, stack.peek())
    }
}