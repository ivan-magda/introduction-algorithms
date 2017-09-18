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

fun main(args: Array<String>) {
    val array = arrayOf(2, 3, 8, 6, 1)
    println("Inversions: ${getInversions(array)}")
}
