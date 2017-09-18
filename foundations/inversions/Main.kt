import kotlin.collections.ArrayList

fun getInversions(array: Array<Int>): List<Pair<Int, Int>> {
    val inversions = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until array.size) {
        (i + 1 until array.size)
                .asSequence()
                .filter { i < it && array[i] > array[it] }
                .mapTo(inversions) { Pair(i, it) }
    }

    return ArrayList(inversions)
}

fun countInversions(array: Array<Int>): Long {
    return sort(array, Array<Int>(array.size, { 0 }), 0, array.size - 1)
}

private fun sort(array: Array<Int>, buffer: Array<Int>, start: Int, end: Int): Long {
    if (start >= end) {
        return 0
    }

    val middle = start + (end - start) / 2
    val left = sort(array, buffer, start, middle)
    val right = sort(array, buffer, middle + 1, end)

    return left + right + mergeHalves(array, buffer, start, middle, end)
}

private fun mergeHalves(array: Array<Int>, buffer: Array<Int>, start: Int, middle: Int, end: Int): Long {
    var count: Long = 0
    val rightStart = middle + 1
    val size = end - start + 1

    var left = start
    var right = rightStart
    var index = start

    while (left <= middle && right <= end) {
        if (array[left] <= array[right]) {
            buffer[index++] = array[left++]
        } else {
            buffer[index++] = array[right++]
            count += (middle - left + 1).toLong()
        }
    }

    System.arraycopy(array, left, buffer, index, middle - left + 1)
    System.arraycopy(array, right, buffer, index, end - right + 1)
    System.arraycopy(buffer, start, array, start, size)

    return count
}

fun main(args: Array<String>) {
    val array = arrayOf(2, 3, 8, 6, 1)

    println("Inversions: ${getInversions(array)}")
    println("Count inversions = ${countInversions(array)}")
}
