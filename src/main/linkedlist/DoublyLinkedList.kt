package main.linkedlist

class DoublyLinkedList<T> : Iterable<T?> {

    private var size: Int = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private data class Node<T>(var data: T?, var previus: Node<T>?, var next: Node<T>?)

    fun clear() {
        var trav = head
        while (trav != null) {
            val next = trav.next
            trav.previus = null
            trav.next = null
            trav.data = null
            trav = next
        }
        trav = null
        head = null
        tail = null
        size = 0
    }

    fun size(): Int = size

    fun isEmpty(): Boolean = size() == 0

    fun add(elm: T?) {
        addLast(elm)
    }

    fun addLast(elm: T?) {
        if (isEmpty()) {
            Node(elm, null, null).apply {
                head = this
                tail = this
            }
        } else {
            Node(elm, tail, null).apply {
                /*
                * [1, 2, 3], 4 is added, so the next of the last tail (3) is 4
                * */
                tail?.next = this
                /*
                * the new tail is the 4
                * */
                tail = this
            }

        }
        size++
    }

    fun addFirst(elm: T?) {
        if (isEmpty()) {
            Node(elm, null, null).apply {
                head = this
                tail = this
            }
        } else {
            Node(elm, null, head).apply {
                /*
                * [1, 2, 3], 0 is added in the head, and 1 was the head, so 1 will point to the new node (0)
                * */
                head?.previus = this
                /*
                * the new head will be change to 0
                * */
                head = this
            }

        }
        size++
    }

    fun peakFirst(): T? {
        if (isEmpty()) throw RuntimeException("Empty list")
        return head?.data
    }

    fun peakLast(): T? {
        if (isEmpty()) throw RuntimeException("Empty list")
        return tail?.data
    }

    fun removeFirst(): T? {
        if (isEmpty()) throw RuntimeException("Empty list")

        val d = head?.data

        /*
        * [1, 2, 3, 4], 1 is removed
        * 2 -> was the next from the 1, so it will be the new head
        * */
        head = head?.next
        size--

        if (isEmpty()) tail = null
        else {
            /*
            * 2 -> its previous was the 1, now will be null
            * */
            head?.previus = null
        }

        return d
    }

    fun removeLast(): T? {
        if (isEmpty()) throw RuntimeException("Empty list")

        val d = tail?.data

        /*
        * [1, 2, 3, 4], 4 is removed
        * 4 -> its previous was pointed to 3, so 3 is the new tail
        * */
        tail = tail?.previus
        size--

        if (isEmpty()) head = null
        else {
            /*
             * 3 -> its next was pointed to 4, so now will point to null
             * */
            tail?.next = null
        }

        return d
    }

    private fun remove(node: Node<T>?): T? {
        if (isEmpty()) throw RuntimeException("Empty list")

        // is the head
        if (node?.previus == null)
            return removeFirst()

        // is the tail
        if (node.next == null)
            return removeLast()

        // Make the pointers of adjacent nodes skip over 'node'
        /*
        * [1, 2, 3, 4, 5], removing the 3
        * 3 next is 4 and its previous is 3, but now will be the previous from the 3, the 2
        * 3 previous is 2 and its next is 3, but now will be the next from the 3, the 4
        * 2 -> <- 4
        * */
        node.next?.previus = node.previus
        node.previus?.next = node.next

        val d = node.data

        // Memory cleanup
        node.data = null
        node.previus = null
        node.next = null

        size--

        return d
    }

    fun remove(data: Any?): Boolean {
        if (isEmpty()) throw RuntimeException("Empty list")

        var trav = head

        if (data == null) {
            var i = 0
            while (trav != null) {
                if (i == size) return false

                if (trav.data == null) {
                    remove(trav)
                    return true
                }
                trav = trav.next
                i++
            }
        } else {
            var i = 0
            while (trav != null) {
                if (i == size) return false

                if (trav.data == data) {
                    remove(trav)
                    return true
                }
                trav = trav.next
                i++
            }
        }

        return false
    }

    fun removeAt(index: Int): T? {
        if (index < 0 || index >= size) {
            throw  IndexOutOfBoundsException()
        }

        var trav: Node<T>?

        if (index < size / 2) {
            trav = head
            for (i in 0 until index) {
                trav = trav?.next
            }
        } else {
            trav = tail
            for (i in size - 1 downTo index) {
                trav = trav?.previus
            }
        }

        return remove(trav)
    }

    fun indexOf(data: Any?): Int {
        var index = 0

        if (isEmpty()) throw RuntimeException("Empty list")

        var trav = head

        if (data == null) {
            while (trav != null) {
                if (index == size) break

                if (trav.data == null) {
                    remove(trav)
                    return index
                }
                trav = trav.next
                index++
            }
        } else {
            while (trav != null) {
                if (index == size) break

                if (trav.data == data) {
                    remove(trav)
                    return index
                }
                trav = trav.next
                index++
            }
        }

        return -1
    }

    fun contains(data: Any?): Boolean {
        return indexOf(data) != -1
    }

    // todo: finish it
    override fun iterator(): Iterator<T?> {
        return object : Iterator<T?> {
            private var trav = head
            override fun hasNext(): Boolean {
                return trav != null
            }

            override fun next(): T? {
                val data = trav?.data
                trav = trav?.next
                return data
            }
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("[ ")
        var trav: Node<T>? = head
        while (trav != null) {
            sb.append(trav.data.toString() + ", ")
            trav = trav.next
        }
        sb.append(" ]")
        return sb.toString()
    }

}