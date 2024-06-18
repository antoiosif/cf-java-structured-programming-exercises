package gr.aueb.cf.ch6;

/**
 * Finds in a sorted int-array that contains duplicate numbers
 * the low and high index of a specific number.
 */
public class LowHighIndexApp {

    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8};
        int[] arrLowHighIndex;
        int key = 8;

        arrLowHighIndex = getLowAndHighIndexOf(arr, key);
        if (arrLowHighIndex.length == 2) {
            System.out.printf("Low and High of '%d': {%d, %d}", key, arrLowHighIndex[0], arrLowHighIndex[1]);
        } else {
            System.out.printf("'%d' is not found at least twice in the array.", key);
        }
    }

    /**
     * Finds in a sorted int-array that contains duplicate numbers
     * the low and high index of a specific number and returns a
     * new array that contains those two indexes.
     *
     * @param arr   the source array.
     * @param key   the number to be found.
     * @return      an array of two elements (the low and high
     *              index of the key).
     */
    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int[] arrayToReturn = new int[2];
        int count = 0;
        int high = 0;

        if (arr == null || arr.length == 0) return new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                count++;
                high = i;
            } else if (arr[i] > key) {
                break;
            }
        }
        if (count < 2) return new int[0];
        arrayToReturn[0] = high - count + 1;
        arrayToReturn[1] = high;

        return arrayToReturn;
    }
}
