package gr.aueb.cf.ch6;

/**
 * Finds the max position and value of an int-array
 * based on a generic method.
 */
public class ArrayMaxGenericMethodApp {

    public static void main(String[] args) {
        int[] arr = {1, 24, 3, 56, 10};
        int maxPosition = 0;

        maxPosition = getMaxPosition(arr, 0, arr.length - 1);
        if (maxPosition == -1) {
            System.out.println("Error in array dimensions.");
        } else {
            System.out.printf("Max value: %d, Max Position: %d", arr[maxPosition], maxPosition + 1);
        }
    }

    /**
     * Returns the position of the element with the max value
     * in a source array.
     *
     * @param arr       the source array.
     * @param low       starting position in the array.
     * @param high      ending position in the array.
     * @return          the position of the array containing the
     *                  max value.
     */
    public static int getMaxPosition(int[] arr, int low, int high) {
        int maxPosition = low;
        int maxValue;

        if (arr == null || arr.length == 0) return -1;
        if (low < 0 || high > arr.length -1 || low > high) return -1;
        maxValue = arr[maxPosition];
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] > maxValue) {
                maxPosition = i;
                maxValue = arr[i];
            }
        }
        return maxPosition;
    }
}
