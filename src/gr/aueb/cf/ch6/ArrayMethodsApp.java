package gr.aueb.cf.ch6;

/**
 * Implements 5 different methods on an int-array:
 * 1. Search for a specific value (returns the position
 *      of the element).
 * 2. Filtering the even elements (prints only the even elements).
 * 3. Mapping each element with double its value (returns
 *      a new array).
 * 4. Check if there is at least one positive number
 *      (returns true/false).
 * 5. Check if all the elements are positive (returns
 *      true/false).
 */
public class ArrayMethodsApp {

    public static void main(String[] args) {
        int[] arr = {5, -16, 12, 0, 1, 3, 22, -35, 42, 6};
        int key = 12;
        int keyPosition;
        int[] arrDouble;

        // Prints the source array
        System.out.print("Πίνακας: ");
        printArray(arr);
        System.out.println();

        // Prints the result of method 1
        keyPosition = getPosition(arr, key);
        if (keyPosition == -1) {
            System.out.printf("1. Το στοιχείο %d δεν βρέθηκε.", key);
        } else {
            System.out.printf("1. Το στοιχείο %d βρέθηκε στη θέση %d.", key, keyPosition + 1);
        }
        System.out.println();

        // Prints the result of method 2
        System.out.print("2. Ζυγοί: ");
        filterEvens(arr);
        System.out.println();

        // Prints the result of method 3
        arrDouble = mapDouble(arr);
        System.out.print("3. Mapping στοιχείων πίνακα με το διπλάσιο: ");
        printArray(arrDouble);
        System.out.println();

        // Prints the result of method 4
        System.out.println("4. Στον πίνακα υπάρχει έστω και ένας θετικός αριθμός: " + hasOnePositive(arr));

        // Prints the result of method 5
        System.out.println("5. Στον πίνακα όλα τα στοιχεία είναι θετικοί αριθμοί: " + areAllPositive(arr));
    }

    /**
     * Searches an array to find a specific value and
     * returns the position of the array if the value
     * is found, -1 otherwise.
     *
     * @param arr   the source array.
     * @param key   the value that is being searched.
     * @return      the position of the value in the
     *              array if the value is found, -1
     *              otherwise.
     */
    public static int getPosition(int[] arr, int key) {
        if (arr == null || arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Traverses an array and prints only the even
     * elements.
     *
     * @param arr   the source array.
     */
    public static void filterEvens(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int item : arr) {
            if (item % 2 == 0) {
                System.out.print(item + " ");
            }
        }
    }

    /**
     * Returns a new array with double the value of
     * each element of the source array.
     *
     * @param arr   the source array.
     * @return      a new array with elements equal
     *              to double the initial array
     *              elements.
     */
    public static int[] mapDouble(int[] arr) {
        int[] arrayToReturn;

        if (arr == null || arr.length == 0) return new int[0];
        arrayToReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrayToReturn[i] = arr[i] * 2;
        }
        return arrayToReturn;
    }

    /**
     * Traverses an array to decide if it contains
     * at least one positive number.
     *
     * @param arr   the source array.
     * @return      true if there is at least one
     *              positive number, false otherwise.
     */
    public static boolean hasOnePositive(int[] arr) {
        boolean hasPositive = false;

        if (arr == null || arr.length == 0) return false;
        for (int item : arr) {
            if (item > 0) {
                hasPositive = true;
                break;
            }
        }
        return hasPositive;
    }

    /**
     * Traverses an array to decide if all its
     * elements are positive numbers.
     *
     * @param arr   the source array.
     * @return      true if all the elements are
     *              positive, False otherwise.
     */
    public static boolean areAllPositive(int[] arr) {
        boolean areAllPositive = true;

        if (arr == null || arr.length == 0) return false;
        for (int item : arr) {
            if (item < 0) {
                areAllPositive = false;
                break;
            }
        }
        return areAllPositive;
    }

    /**
     * Traverses an array and prints the value
     * of each element.
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
