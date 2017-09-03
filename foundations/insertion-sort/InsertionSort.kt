import java.util.*

fun sort(array: Array<Int>) {
    var i = 1
    while (i < array.size) {
        val key = array[i]

        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j--]
            j--
        }

        array[j + 1] = key
        i++
    }
}

fun main(args: Array<String>) {
    val array = arrayOf(1, 3, 2, 4, 6, 5, 7, 9, 8)
    sort(array)

    println(Arrays.toString(array))
}
