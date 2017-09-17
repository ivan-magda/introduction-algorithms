import java.util.Arrays;

public class BinarySearch {

    // Recursively.

    public static int recursively(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        return searchRecursively(array, target, 0, array.length - 1);
    }

    private static int searchRecursively(int[] array, int element, int start, int end) {
        if (end < start) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (element == array[middle]) {
            return middle;
        } else if (element < array[middle]) {
            return searchRecursively(array, element, start, middle - 1);
        } else {
            return searchRecursively(array, element, middle + 1, end);
        }
    }

    // Iterative.

    public static int iterative(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int middle;

        while (start <= end) {
            middle = end + start / 2;
            if (target == a[middle]) {
                return middle;
            } else if (a[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Search 7 recursively: " + recursively(array, 7));
        System.out.println("Search 7 iterative: " + iterative(array, 7));
    }
}
