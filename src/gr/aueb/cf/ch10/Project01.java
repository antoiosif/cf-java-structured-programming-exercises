package gr.aueb.cf.ch10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Reads integers in the value range 1-49 from a file
 * (the file should contain 7-49 integers), finds all
 * the possible combinations of 6 numbers, filters them to find
 * those that meet the 5 criteria described below and
 * prints those combinations that meet the criteria in
 * an output file.
 * The 5 criteria are:
 * 1) Having at most 4 even integers.
 * 2) Having at most 4 odd integers.
 * 3) Having at most 2 consecutive integers.
 * 4) Having at most 3 integers with the same ending.
 * 5) Having at most 3 integers in the same group of tens.
 */
public class Project01 {

    public static void main(String[] args) {
        File fdIn = new File("C:/Users/IT/jtmp/numbers.txt");
        File fdOut = new File("C:/Users/IT/jtmp/sets-of-6.txt");
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            numbers = getNumbers(fdIn);
            if (!isValidFile(numbers)) {
                System.out.println("The file does not contain the required amount of data (7-49 integers).");
                return;
            }
            Collections.sort(numbers);
            getSetsOfSix(numbers, fdOut);
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or can not be created.");
        }
    }

    /**
     * Reads integers in the value range 1-49 from a file
     * and creates an ArrayList that contains them.
     *
     * @param fd    the source file.
     * @return      an ArrayList containing all the
     *              integers (in the value range 1-49) of
     *              the source file.
     * @throws FileNotFoundException
     *              if the source file does not exist.
     */
    public static ArrayList<Integer> getNumbers(File fd) throws FileNotFoundException {
        Scanner in = new Scanner(fd);
        ArrayList<Integer> numbers = new ArrayList<>();
        String token = "";
        int num = 0;

        while (in.hasNext()) {
            token = in.next();
            if (!isInt(token)) continue;
            num = Integer.parseInt(token);
            if (isValidNumber(num)) numbers.add(num);
        }
        return numbers;
    }

    /**
     * Checks if a String represents an integer.
     *
     * @param s     the String to be checked.
     * @return      true if the String represents
     *              an integer, false otherwise.
     */
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a number is valid. To be valid, the
     * number has to be in the value range 1-49.
     *
     * @param num   the number to be validated.
     * @return      true if the number is in the
     *              value range 1-49, false otherwise.
     */
    public static boolean isValidNumber(int num) {
        return num >= 1 && num <= 49;
    }

    /**
     * Checks if an ArrayList of integers that was
     * created from a file (and thus the file) contains
     * the required amount of integers for the program
     * to be executed. That is more than 6 and at most
     * 49 integers (7-49).
     *
     * @param arr   the source ArrayList.
     * @return      true if the source ArrayList contains
     *              7-49 integers, false otherwise.
     */
    public static boolean isValidFile(ArrayList<Integer> arr) {
        return (arr !=null) && (arr.size() >= 7) && (arr.size() <= 49);
    }

    /**
     * Finds all the possible combinations of 6 integers
     * that a source ArrayList of integers can provide,
     * filters them to find those that meet the 5 criteria
     * described below and prints those combinations that
     * meet the criteria in an output file.
     * The 5 criteria are:
     * 1) Having at most 4 even integers.
     * 2) Having at most 4 odd integers.
     * 3) Having at most 2 consecutive integers.
     * 4) Having at most 3 integers with the same ending.
     * 5) Having at most 3 integers in the same group of tens.
     *
     * @param arr   the source ArrayList.
     * @param fd    the output file.
     * @throws FileNotFoundException
     *              if the output file does not exist or
     *              can not be created.
     */
    public static void getSetsOfSix(ArrayList<Integer> arr, File fd) throws FileNotFoundException {
        PrintStream ps = new PrintStream(fd);
        int n = 6;
        int[] set = new int[6];
        boolean isFiltered = false;

        for (int i = 0; i <= arr.size() - n; i++) {
            for (int j = i + 1; j <= arr.size() - n + 1; j++) {
                for (int k = j + 1; k <= arr.size() - n + 2; k++) {
                    for (int l = k + 1; l <= arr.size() - n + 3; l++) {
                        for (int m = l + 1; m <= arr.size() - n + 4; m++) {
                            for (int o = m + 1; o <= arr.size() - n + 5; o++) {
                                set[0] = arr.get(i);
                                set[1] = arr.get(j);
                                set[2] = arr.get(k);
                                set[3] = arr.get(l);
                                set[4] = arr.get(m);
                                set[5] = arr.get(o);
                                isFiltered = filter(set);
                                if (isFiltered) print(ps, set);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Filters an array of integers to decide if it meets
     * the following 5 criteria:
     * 1) Having at most 4 even integers.
     * 2) Having at most 4 odd integers.
     * 3) Having at most 2 consecutive integers.
     * 4) Having at most 3 integers with the same ending.
     * 5) Having at most 3 integers in the same group of tens.
     *
     * @param arr   the source array.
     * @return      true if the array meets all the criteria,
     *              false otherwise.
     */
    public static boolean filter(int[] arr) {
        return !hasMTNEvens(arr, 4) && !hasMTNOdds(arr, 4) && !hasMTTwoConsecutive(arr)
                && !hasMTNSameEnding(arr, 3) && !hasMTNSameGroupOfTens(arr, 3);
    }

    /**
     * Traverses an array to decide if it contains
     * more than N even numbers.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains more
     *                      than N evens, false otherwise.
     */
    public static boolean hasMTNEvens(int[] arr, int threshold) {
        int count = 0;

        for (int item : arr) {
            if ((item % 2) == 0) count++;
        }
        return count > threshold;
    }

    /**
     * Traverses an array to decide if it contains
     * more than N odd numbers.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains more
     *                      than N odds, false otherwise.
     */
    public static boolean hasMTNOdds(int[] arr, int threshold) {
        int count = 0;

        for (int item : arr) {
            if ((item % 2) != 0) count++;
        }
        return count > threshold;
    }

    /**
     * Traverses an array to decide if it contains
     * more than two consecutive numbers.
     *
     * @param arr   the source array.
     * @return      true, if the array contains more
     *              than two consecutive numbers,
     *              false otherwise.
     */
    public static boolean hasMTTwoConsecutive(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if ((arr[i] == arr[i+1] - 1) && (arr[i] == arr[i+2] - 2)) count++;
        }
        return count > 1;
    }

    /**
     * Traverses an array to decide if it contains
     * more than N numbers with the same ending.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains more
     *                      than N numbers with the same ending,
     *                      false otherwise.
     */
    public static boolean hasMTNSameEnding(int[] arr, int threshold) {
        int[] endings = new int[10];    // possible endings: 0-9

        for (int item : arr) {          // populates the array 'endings'
            endings[item % 10]++;
        }
        for (int ending : endings) {
            if (ending > threshold) return true;
        }
        return false;
    }

    /**
     * Traverses an array to decide if it contains
     * more than N numbers in the same group of ten.
     *
     * @param arr           the source array.
     * @param threshold     the number N.
     * @return              true, if the array contains more
     *                      than N numbers in the same group
     *                      of ten, false otherwise.
     */
    public static boolean hasMTNSameGroupOfTens(int[] arr, int threshold) {
        int[] tens = new int[5];        // possible groups of tens: 1-9, 10-19, 20-29, 30-39, 40-49

        for (int item : arr) {          // populates the array 'tens'
            tens[item / 10]++;
        }
        for (int ten : tens) {
            if (ten > threshold) return true;
        }
        return false;
    }

    /**
     * Traverses an array and prints its contents
     * to PrintStream.
     *
     * @param ps    the PrintStream Object.
     * @param arr   the source array.
     */
    public static void print(PrintStream ps, int[] arr) {
        for (int item : arr) {
            ps.print(item + " ");
        }
        ps.println();
    }
}
