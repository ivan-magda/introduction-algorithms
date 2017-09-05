import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = getMinIndex(array, i, array.length);
            swap(array, i, minIdx);
        }
    }

    private static int getMinIndex(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = start; i < end; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 6, 1, 7};
        sort(array);

        System.out.println(Arrays.toString(array));
    }
}
