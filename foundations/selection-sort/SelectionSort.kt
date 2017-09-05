import java.util.*

fun selectionSort(array: Array<Int>) {
    for (i in 0 until array.size - 1) {
        val minIndex = getMinIndex(array, i, array.size)
        swap(array, i, minIndex)
    }
}

fun getMinIndex(array: Array<Int>, start: Int, end: Int): Int {
    var minValue = Integer.MAX_VALUE
    var minIndex = -1

    for (i in start until end) {
        if (array[i] < minValue) {
            minValue = array[i]
            minIndex = i
        }
    }

    return minIndex
}

fun swap(array: Array<Int>, lhs: Int, rhs: Int) {
    val temp = array[lhs]
    array[lhs] = array[rhs]
    array[rhs] = temp
}

fun main(args: Array<String>) {
    val array = arrayOf(2, 4, 5, 2, 8, 45)
    selectionSort(array)

    println(Arrays.toString(array))
}
