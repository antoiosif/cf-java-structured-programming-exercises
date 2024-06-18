package gr.aueb.cf.ch6;

/**
 * Finds the position and value of an int-array
 * with the second min value.
 */
public class ArraySecondMinApp {

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 4, 16, 3, 2, 6};
        int minPosition = 0;
        int minValue = 0;
        int secondMinPosition = 0;

        minPosition = getMinPosition(arr, 0, arr.length - 1);
        minValue = arr[minPosition];
        secondMinPosition = getSecondMinPosition(arr, minValue);
        System.out.printf("Second Min Value: %d, Position: %d", arr[secondMinPosition], secondMinPosition + 1);
    }

    /**
     * Returns the position of the element with the
     * second min value in a source array.
     *
     * @param arr           the source array.
     * @param minValue      the min value of the array.
     * @return              the position of the array
     *                      containing the second min value.
     */
    public static int getSecondMinPosition(int[] arr, int minValue) {
        int secondMinPosition = 0;
        int secondMinValue;

        if (arr == null || arr.length < 2) return -1;
        secondMinValue = arr[secondMinPosition];
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] > minValue) && (arr[i] < secondMinValue)) {
                secondMinPosition = i;
                secondMinValue = arr[i];
            }
        }
        return secondMinPosition;
    }

    /**
     * Returns the position of the element with the
     * min value in a source array.
     *
     * @param arr       the source array.
     * @param low       starting position in the array.
     * @param high      ending position in the array.
     * @return          the position of the array containing
     *                  the min value.
     */
    public static int getMinPosition(int[] arr, int low, int high){
        int minPosition = low;
        int minValue;

        if (arr == null || arr.length == 0) return -1;
        if (low < 0 || high > arr.length -1 || low > high) return -1;
        minValue = arr[minPosition];
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < minValue) {
                minPosition = i;
                minValue = arr[i];
            }
        }
        return minPosition;
    }
}
