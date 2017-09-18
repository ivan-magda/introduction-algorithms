import java.util.*

fun insertionSort(array: Array<Int>) {
    insertionSort(array, 1, array.lastIndex)
}

fun insertionSort(array: Array<Int>, start: Int, end: Int) {
    val startIndex: Int = if (start >= 1) {
        start
    } else {
        1
    }

    for (i in startIndex..end) {
        val key = array[i]

        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j--]
        }

        array[j + 1] = key
    }
}

fun mergeSort(array: Array<Int>) {
    if (!array.isEmpty()) {
        val threshold = (array.size / 4) + 1
        mergeSort(array, Array(array.size, { 0 }), 0, array.lastIndex, threshold)
    }
}

fun mergeSort(array: Array<Int>, buffer: Array<Int>, start: Int, end: Int, thresholdForInsertionSort: Int) {
    if (end - start <= thresholdForInsertionSort) {
        insertionSort(array, start, end)
    } else if (start < end) {
        val middle = start + (end - start) / 2
        mergeSort(array, buffer, start, middle, thresholdForInsertionSort)
        mergeSort(array, buffer, middle + 1, end, thresholdForInsertionSort)
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
    val array = arrayOf(8, 2, 5, 9, 21, 2, 3, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 45, 20, 13, 25, 75, 1)

    println("Unsorted: ${Arrays.toString(array)}")

    mergeSort(array)
    println("Sorted: ${Arrays.toString(array)}")
}
