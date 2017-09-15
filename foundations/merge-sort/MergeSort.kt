import java.util.*

fun mergeSort(array: Array<Int>) {
    if (array.size > 1) {
        mergeSort(array, Array<Int>(array.size, { 0 }), 0, array.size - 1)
    }
}

fun mergeSort(array: Array<Int>, buffer: Array<Int>, start: Int, end: Int) {
    if (start < end) {
        val middle = start + (end - start) / 2
        mergeSort(array, buffer, start, middle)
        mergeSort(array, buffer, middle + 1, end)
        merge(array, buffer, start, middle, end)
    }
}

fun merge(array: Array<Int>, buffer: Array<Int>, start: Int, middle: Int, end: Int) {
    val size = end - start + 1
    var left = start
    var right = middle + 1
    var copy = start

    while (left <= middle && right <= end) {
        if (array[left] <= array[right]) {
            buffer[copy++] = array[left++]
        } else {
            buffer[copy++] = array[right++]
        }
    }

    System.arraycopy(array, left, buffer, copy, middle - left + 1)
    System.arraycopy(array, right, buffer, copy, end - right + 1)
    System.arraycopy(buffer, start, array, start, size)
}

fun main(args: Array<String>) {
    val array = arrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
    println("Unsorted: ${Arrays.toString(array)}")

    mergeSort(array)
    println("Sorted: ${Arrays.toString(array)}")
}
