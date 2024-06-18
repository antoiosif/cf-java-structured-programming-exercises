package gr.aueb.cf.ch6;

/**
 * Finds the position and value of an int-array
 * with the second min value.
 * The program works effectively on arrays that
 * contain only 1 element with min value.
 */
public class ArraySecondMinApp2 {

    public static void main(String[] args) {
        int[] arr = {1, 19, 13, 9, 10, 8, 6, 2};
        int secondMinPosition = 0;

        secondMinPosition = getSecondMinPosition(arr);
        System.out.printf("Second Min Value: %d, Position: %d", arr[secondMinPosition], secondMinPosition + 1);
    }

    /**
     * Returns the position of the element with the
     * second min value in a source array.
     *
     * @param arr       the source array.
     * @return          the position of the array containing
     *                  the second min value.
     */
    public static int getSecondMinPosition(int[] arr) {
        int secondMinPosition = -1;
        int secondMinValue;
        int count = 0;

        if (arr == null || arr.length < 2) return -1;
        for (int i = 0; i < arr.length; i++) {
            secondMinPosition = i;
            secondMinValue = arr[secondMinPosition];
            for (int item : arr) {
                if (item < secondMinValue) {
                    count++;
                }
            }
            if (count == 1) break;   // the second min value has only 1 value smaller than it (the min value)
            count = 0;
        }
        return secondMinPosition;
    }
}