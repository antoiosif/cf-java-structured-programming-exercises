package gr.aueb.cf.ch6;

/**
 * Finds and prints the maximum number of cars parked at the
 * same time. The data come from a source two-dimensional
 * array that contains the time of arrival and the time of
 * departure for each car.
 * ex. {1012, 1136}: 1012 = arrival time, 1136 = departure
 * time
 */
public class ParkingApp {

    public static void main(String[] args) {
        int[][] arr = {{1012, 1136}, {1317, 1417}, {1015, 1020}};
        int[][] combinedArr;

        // Create the combined array
        combinedArr = getCombinedArray(arr);
        // Sort the combined array by time (column 0)
        selectionSortTwoDimArrayByCol(combinedArr, 0);
        System.out.println("Max Cars: " + getMaxCars(combinedArr));
    }

    /**
     * Creates a new two-dimensional int-array of n rows and 2 columns,
     * where n is the source array's total elements.
     * Each row of the new array contains: in column 0 an element of the
     * source array, and in column 1 the number 1 if the element represents
     * the arrival time or 0 if it represents the departure time.
     *
     * @param arr   the source array.
     * @return      the new two-dimensional int-array.
     */
    public static int[][] getCombinedArray(int[][] arr) {
        int[][] arrayToReturn;
        int k = 0;      // indexer for the rows of the 'arrayToReturn'

        if (arr == null || arr.length == 0) return new int[0][0];
        arrayToReturn = new int[2 * arr.length][2];   // the source array contains 2 elements per row => total elements = 2 * rows
        for (int[] row : arr) {
            for (int j = 0; j < row.length; j++) {
                arrayToReturn[k][0] = row[j];                 // col 0: element from the source array
                arrayToReturn[k++][1] = (j == 0) ? 1 : 0;     // col 1: 0 (departure) or 1 (arrival)
            }
        }
        return arrayToReturn;
    }

    /**
     * Sorts a two-dimensional int-array based on one of its
     * columns.
     *
     * @param arr   the source array.
     * @param col   the column based on which the array
     *              is sorted.
     */
    public static void selectionSortTwoDimArrayByCol(int[][] arr, int col) {
        int minPosition;
        int minValue;

        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].length < col) return;     // checks that the column exists in every row
            minPosition = i;
            minValue = arr[i][col];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][col] < minValue) {
                    minPosition = j;
                    minValue = arr[j][col];
                }
            }
            if (minPosition != i) {
                swap(arr, i, minPosition);
            }
        }
    }

    /**
     * Mutually interchanges two rows of a two-dim array
     * (essentially swaps the references of the two rows).
     *
     * @param arr   the source array.
     * @param i     the indexer of the first row.
     * @param j     the indexer of the second row.
     */
    public static void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Finds the max number of cars parked at the same time.
     *
     * @param arr   the source array.
     * @return      the max number of cars parked at
     *              the same time.
     */
    public static int getMaxCars(int[][] arr) {
        int maxCars = 0;
        int count = 0;

        if (arr == null || arr.length == 0) return 0;
        for (int[] row : arr) {
            if (row[1] == 1) {      // continuous 1s essentially means cars parked at the same time
                count++;
            } else {
                if (count > maxCars) {
                    maxCars = count;
                }
                count--;
            }
        }
        return maxCars;
    }
}
