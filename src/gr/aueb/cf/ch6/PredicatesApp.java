package gr.aueb.cf.ch6;

import java.util.Scanner;

/**
 * The user inserts 6 integers (1-49) and
 * the program checks 5 predicates.
 */
public class PredicatesApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[6];

        System.out.println("Παρακαλώ εισάγετε 6 ακεραίους (1-49):");
        // populate the array 'arr' with the user's inputs
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        // check that the input integers are valid (1-49)
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] < 1 || arr[i] > 49) {
                System.out.println("Εισάγατε μη έγκυρο ακέραιο: " + arr[i]);
                System.out.println("Παρακαλώ εισάγετε νέο ακέραιο (1-49):");
                arr[i] = in.nextInt();
            }
        }
        System.out.print("Εξάδα: ");
        printArray(arr);
        System.out.println();
        System.out.println("1. Δεν έχει πάνω από 3 άρτιους: " + hasLTNEvens(arr, 4));
        System.out.println("2. Δεν έχει πάνω από 3 περιττούς: " + hasLTNOdds(arr, 4));
        System.out.println("3. Δεν έχει πάνω από 3 συνεχόμενους: " + hasLTFourConsecutive(arr));
        System.out.println("4. Δεν έχει πάνω από 3 αριθμούς με τον ίδιο λήγοντα: " + hasLTNSameEnding(arr, 4));
        System.out.println("5. Δεν έχει πάνω από 3 αριθμούς στην ίδια δεκάδα: " + hasLTNSameGroupOfTens(arr, 4));
    }

    /**
     * Traverses an array to decide if it contains
     * less than N even numbers.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains less
     *                      than N evens, false otherwise.
     */
    public static boolean hasLTNEvens(int[] arr, int threshold) {
        int count = 0;

        if (arr == null || arr.length == 0) return false;
        for (int item : arr) {
            if (item % 2 == 0){
                count++;
            }
        }
        return count < threshold;
    }

    /**
     * Traverses an array to decide if it contains
     * less than N odd numbers.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains less
     *                      than N odds, false otherwise.
     */
    public static boolean hasLTNOdds(int[] arr, int threshold) {
        int count = 0;

        if (arr == null || arr.length == 0) return false;
        for (int item : arr) {
            if (item % 2 != 0){
                count++;
            }
        }
        return count < threshold;
    }

    /**
     * Traverses an array to decide if it contains
     * less than four consecutive numbers.
     *
     * @param arr   the source array.
     * @return      true, if the array contains less
     *              than four consecutive numbers,
     *              false otherwise.
     */
    public static boolean hasLTFourConsecutive(int[] arr) {
        int count = 0;

        if (arr == null || arr.length == 0) return false;
        for (int i = 0; i < arr.length - 3; i++) {
            if ((arr[i] == arr[i+1] - 1) && (arr[i] == arr[i+2] - 2) && (arr[i] == arr[i+3] - 3)) {
                count++;
            }
        }
        return count < 1;
    }

    /**
     * Traverses an array to decide if it contains
     * less than N numbers with the same ending.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains less
     *                      than N numbers with the same ending,
     *                      false otherwise.
     */
    public static boolean hasLTNSameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];            // possible endings: 0-9

        if (arr == null || arr.length == 0) return false;
        for (int item : arr) {                  // populates the array 'endings'
            endings[item % 10]++;
        }
        for (int item : endings) {
            if (item >= threshold) {
                return false;
            }
        }
        return true;
    }

    /**
     * Traverses an array to decide if it contains
     * less than N numbers in the same group of ten.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains less
     *                      than N numbers in the same group
     *                      of ten, false otherwise.
     */
    public static boolean hasLTNSameGroupOfTens(int[] arr, int threshold) {
        int[] tens = new int[5];          // possible groups of tens: 1-9, 10-19, 20-29, 30-39, 40-49

        if (arr == null || arr.length == 0) return false;
        for (int item : arr) {              // populates the array 'tens'
            tens[item / 10]++;
        }
        for (int item : tens) {
            if (item >= threshold) {
                return false;
            }
        }
        return true;
    }

    /**
     * Traverses an array and prints its elements.
     *
     * @param arr   the source array.
     */
    public static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
