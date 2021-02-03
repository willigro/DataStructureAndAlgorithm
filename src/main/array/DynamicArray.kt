package main.array

@Suppress("UNCHECKED_CAST")
class DynamicArray<T>(private var capacity: Int = 16) : Iterable<T?> {

    init {
        if (capacity < 0) throw IllegalArgumentException("Illegal Capacity: $capacity")
    }

    private var arr: Array<T?> = newArray()
    private var len: Int = 0

    private fun newArray(length: Int = capacity) = arrayOfNulls<Any>(length) as Array<T?>

    fun size() = len

    fun isEmpty() = size() == 0

    fun get(index: Int): T? = arr[index]

    fun set(index: Int, elm: T?) {
        arr[index] = elm
    }

    fun clear() {
        for (i in 0 until len) {
            arr[i] = null
        }
        len = 0
    }

    fun add(elm: T?) {
        if (capacity <= len + 1) {
            if (capacity == 0) capacity = 1
            else capacity *= 2

            val newArr = newArray()
            for (i in 0 until len) {
                newArr[i] = arr[i]
            }
            arr = newArr
        }

        arr[len++] = elm
    }

    fun removeAt(index: Int): T? {
        if (index >= len || index < 0) throw IndexOutOfBoundsException()

        val newArr = newArray(len - 1)
        var j = 0
        for (i in 0 until len) {
            if (i == index) j--
            else newArr[j] = arr[i]
            j++
        }

        val elm = arr[index]
        arr = newArr
        capacity = --len
        return elm
    }

    fun remove(elm: T?): Boolean {
        val lastLen = len
        val index = indexOf(elm)
        if (index == -1) return false
        removeAt(index)
        return lastLen > len
    }

    fun indexOf(elm: T?): Int {
        for (i in 0 until len) {
            if (elm == null && arr[i] == null || elm == arr[i]) return i
        }
        return -1
    }

    fun contains(elm: T?): Boolean {
        return indexOf(elm) != -1
    }

    override fun toString(): String {
        return if (len == 0) "[]"
        else {
            val sb = StringBuilder(len).append("[")
            for (i in 0 until len - 1) sb.append(arr[i].toString() + ", ")
            sb.append(arr[len - 1].toString() + "]").toString()
        }
    }

    override fun iterator(): Iterator<T?> {
        return object : Iterator<T?> {
            var index: Int = 0
            override fun hasNext(): Boolean {
                return index < len
            }

            override fun next(): T? {
                return arr[index++]
            }
        }
    }
}