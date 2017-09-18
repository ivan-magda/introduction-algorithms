import java.util.*
import kotlin.collections.HashMap

/**
 * Naive Solution O(n^2).
 * <p>
 * Naive solution would be to considered every pair in a given array
 * and return if desired sum is found.
 */
fun findPairWithGivenSumNaive(array: Array<Int>, sum: Int): Pair<Int, Int>? {
    for (i in 0 until array.size) {
        (i + 1 until array.size)
                .filter { array[i] + array[it] == sum }
                .forEach { return Pair(array[i], array[it]) }
    }

    return null
}

/**
 * O(nlogn) solution using Sorting.
 * <p>
 * The idea is to sort the given array in ascending order and maintain search space by maintaining
 * two indexes (low and high) that initially points to two end-points of the array.
 * Then we loop till low is less than high index and reduce search space array[low until high] at each iteration of the loop.
 * We compare sum of elements present at index low and high with desired sum and increment low if sum is less
 * than the desired sum else we decrement high is sum is more than the desired sum.
 * Finally, we return if pair found in the array.
 */
fun findPairWithGivenSumSort(array: Array<Int>, sum: Int): Pair<Int, Int>? {
    Arrays.sort(array)

    var low = 0
    var high = array.lastIndex

    while (low < high) {
        val currentSum = array[low] + array[high]
        when {
            currentSum == sum -> return Pair(array[low], array[high])
            currentSum < sum -> low++
            else -> high--
        }
    }

    return null
}

/**
 * O(n) solution using Hashing.
 * <p>
 * We can use map to easily solve this problem in linear time. The idea is to insert each element of the array[i]
 * in a map. We also checks if difference (array[i], sum - array[i]) already exists in the map or not.
 * If the difference is seen before, we print the pair and return.
 */
fun findPairWithGivenSumHashing(array: Array<Int>, sum: Int): Pair<Int, Int>? {
    val map = HashMap<Int, Int>(array.size)

    for (i in 0 until array.size) {
        val difference = sum - array[i]

        if (map.containsKey(difference)) {
            return Pair(difference, array[i])
        }

        map.put(array[i], i)
    }

    return null
}

fun main(args: Array<String>) {
    val array = arrayOf(8, 2, 5, 9, 21, 2, 3)
    println("Array: ${Arrays.toString(array)}")

    println("Naive, search for 7: ${findPairWithGivenSumNaive(array, 7)}")
    println("Sort, search for 7: ${findPairWithGivenSumSort(array.clone(), 7)}")
    println("Hashing, search for 7: ${findPairWithGivenSumHashing(array, 7)}")
}
