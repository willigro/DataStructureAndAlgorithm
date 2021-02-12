package main.stack

class IntStack(maxSize: Int) {

    private val array = IntArray(maxSize)
    private var pos = 0

    fun size() = pos

    fun isEmpty() = size() == 0

    fun push(elm: Int) {
        array[pos++] = elm
    }

    fun pop(): Int {
        return array[pos--]
    }

    fun peak(): Int {
        return array[pos - 1]
    }
}