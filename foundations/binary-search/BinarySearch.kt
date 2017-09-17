import java.util.*

fun binarySearchRecursively(array: Array<Int>, target: Int): Int {
    if (array.isEmpty()) {
        return -1
    }

    return binarySearchRecursively(array, target, 0, array.size - 1)
}

private fun binarySearchRecursively(array: Array<Int>, target: Int, start: Int, end: Int): Int {
    if (start > end) {
        return -1
    }

    val middle = start + (end - start) / 2
    val currentValue = array[middle]

    return when {
        target == currentValue -> middle
        target > currentValue -> binarySearchRecursively(array, target, middle + 1, end)
        else -> binarySearchRecursively(array, target, start, middle - 1)
    }
}

fun binarySearchIterative(array: Array<Int>, target: Int): Int {
    var start = 0
    var end = array.size - 1

    while (start <= end) {
        val middle = start + (end - start) / 2
        val currentValue = array[middle]

        when {
            target == currentValue -> return middle
            target > currentValue -> start = middle + 1
            else -> end = middle - 1
        }
    }

    return -1
}

fun main(args: Array<String>) {
    val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    println("Target array: ${Arrays.toString(array)}")
    println("Index of 3 is ${binarySearchIterative(array, 3)}, {iterative}")
    println("Index of 3 is ${binarySearchRecursively(array, 3)}, {recursively}")
}
