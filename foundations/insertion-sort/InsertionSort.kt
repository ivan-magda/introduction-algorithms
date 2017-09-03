import java.util.Arrays

fun sort(array: Array<Int>, predicate: (Int, Int) -> Boolean) {
    for (i in 1 until array.size) {
        val key = array[i]

        var j = i - 1
        while (j >= 0 && predicate(array[j], key)) {
            array[j + 1] = array[j--]
        }

        array[j + 1] = key
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(1, 3, 2, 4, 7, 6, 5, 7, 9, 8)

    sort(array, { lhs, rhs -> lhs > rhs })
    println(Arrays.toString(array))

    sort(array, { lhs, rhs -> lhs < rhs })
    println(Arrays.toString(array))
}
