import java.util.Arrays;

public class InsertionSort {

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // Insert array[i] into sorted sequence array[1..i - 1].
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 3, 6, 5, 7, 9, 8};
        sort(array);

        System.out.println("Sorted: " + Arrays.toString(array));
    }
}
