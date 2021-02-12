package main.stack

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class IntStackTest {

    @Test
    fun `size from a new stack`() {
        val stack = IntStack(10)
        assertEquals(0, stack.size())
    }

    @Test
    fun `size from a stack with items`() {
        val stack = IntStack(10)
        for (i in 0 until 5)
            stack.push(i)
        assertEquals(5, stack.size())
    }

    @Test
    fun `get false when call isEmpty and the stack has items`() {
        val stack = IntStack(10)
        for (i in 0 until 5)
            stack.push(i)
        assertFalse(stack.isEmpty())
    }

    @Test
    fun `get true when call isEmpty and the stack has no items`() {
        val stack = IntStack(10)
        assertTrue(stack.isEmpty())
    }

    @Test
    fun push() {
        val stack = IntStack(10)
        stack.push(1)
        assertFalse(stack.isEmpty())
        assertEquals(1, stack.size())
    }

    @Test
    fun pop() {
        val stack = IntStack(10)
        stack.push(1)

        assertFalse(stack.isEmpty())
        assertEquals(1, stack.size())

        stack.pop()

        assertTrue(stack.isEmpty())
        assertEquals(0, stack.size())
    }

    @Test
    fun peak() {
        val stack = IntStack(10)
        stack.push(1)
        assertEquals(1, stack.peak())

        stack.push(5)
        assertEquals(5, stack.peak())

        stack.push(9)
        assertEquals(9, stack.peak())

        stack.pop()
        assertEquals(5, stack.peak())

        stack.push(9)
        assertEquals(9, stack.peak())
    }
}