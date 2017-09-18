import java.util.*

fun bubbleSort(array: Array<Int>) {
    for (i in 0 until array.size) {
        (0 until array.size - i - 1)
                .asSequence()
                .filter { array[it] > array[it + 1] }
                .forEach { swap(array, it, it + 1) }
    }
}

fun swap(array: Array<Int>, lhs: Int, rhs: Int) {
    val temp = array[lhs]
    array[lhs] = array[rhs]
    array[rhs] = temp
}

fun main(args: Array<String>) {
    val array = arrayOf(8, 2, 5, 9, 21, 2, 3, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 45, 20, 13, 25, 75, 1)

    println("Unsorted: ${Arrays.toString(array)}")

    bubbleSort(array)
    println("Sorted: ${Arrays.toString(array)}")
}
