import java.util.*

fun insertionSort(array: Array<Int>) {
    for (i in 1 until array.size) {
        val key = array[i]
        val beforeIndex = i - 1

        if (array[beforeIndex] > key) {
            // Start index of sorted subarray.
            var start = 0
            // End index of sorted subarray.
            var end = beforeIndex

            // Search for a position where to insert current element.
            while (start <= end) {
                val middle = start + (end - start) / 2
                if (array[middle] < key) {
                    start = middle + 1
                } else {
                    end = middle - 1
                }
            }

            for (j in beforeIndex downTo start) {
                array[j + 1] = array[j]
            }
            array[start] = key
        }
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(1, 9, 3, 5, 4, 6, 7, 8, 2)
    insertionSort(array)

    println(Arrays.toString(array))
}
