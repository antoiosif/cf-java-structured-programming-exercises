package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * Prints a menu with 6 choices for the user
 * to choose from, and uses methods to implement
 * them. The process is repeated until the user
 * terminates it.
 */
public class StarsMenuWithErrorCodesApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int numOfStars = 0;
        int errorCode = 0;

        while (true) {
            printMenu();
            choice = in.nextInt();
            errorCode = validateChoice(choice);

            if (errorCode == 1) {
                System.out.println("Επιλέξατε έξοδο.\nΕυχαριστούμε που χρησιμοποιήσατε την εφαρμογή!");
                break;
            }

            if (errorCode == 2) {
                System.out.println("Λάθος επιλογή. Παρακαλώ επιλέξτε 1-6 από τα παρακάτω.");
                continue;
            }

            while (true) {
                System.out.println("Δώστε αριθμό για αστεράκια:");
                numOfStars = in.nextInt();
                errorCode = validateStars(numOfStars);
                if (errorCode == 0) {
                     break;
                }
                System.out.println("Ο αριθμός πρέπει να είναι μεγαλύτερος από 0.");
            }

            printResult(choice, numOfStars);
        }
    }

    /**
     * Prints a CRUD menu.
     */
    public static void printMenu() {
        System.out.println("1. Εμφάνισε n αστεράκια οριζόντια");
        System.out.println("2. Εμφάνισε n αστεράκια κάθετα");
        System.out.println("3. Εμφάνισε n γραμμές με n αστεράκια");
        System.out.println("4. Εμφάνισε n γραμμές με αστεράκια 1-n");
        System.out.println("5. Εμφάνισε n γραμμές με αστεράκια n-1");
        System.out.println("6. Έξοδος από το πρόγραμμα");
        System.out.println("Δώστε επιλογή:");
    }

    /**
     * Checks if the input choice is valid and returns
     * an error code. To be valid, the choice should be
     * 1, 2, 3, 4 or 5.
     *
     * @param choice    the input choice.
     * @return          the error code: 0 if the choice is valid,
     *                  1 if the choice is 6 and 2 for any other choice.
     */
    public static int validateChoice(int choice) {
        int errorCode = 0;

        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                errorCode = 0;
                break;
            case 6:
                errorCode = 1;
                break;
            default:
                errorCode = 2;
                break;
        }

        return errorCode;
    }

    /**
     * Checks if the input integer is valid and returns
     * an error code. To be valid, the integer should be > 0.
     *
     * @param numOfStars     the integer
     * @return      the error code: 0 if the integer is valid and 2 if not.
     */
    public static int validateStars(int numOfStars) {
        int errorCode = 0;

        if (numOfStars <= 0) {
            errorCode = 2;
        } else {
            errorCode = 0;
        }

        return errorCode;
    }

    /**
     * Prints n stars horizontally.
     *
     * @param n     the number of stars
     */
    public static void printStarsH(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * Prints n stars vertically.
     *
     * @param n     the number of stars
     */
    public static void printStarsV(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("*");
        }
    }

    /**
     * Prints n stars in n lines:
     *
     * @param n     the number of stars
     */
    public static void printStarsHV(int n) {
        for (int i = 1; i <= n; i++) {
            printStarsH(n);
        }
    }

    /**
     * Prints n lines with stars in ascending order:
     * 1 star in line 1, 2 stars in line 2, ... ,
     * n stars in line n.
     *
     * @param n     the number of lines
     */
    public static void printStarsAsc(int n) {
        for (int i = 1; i <= n; i++) {
            printStarsH(i);
        }
    }

    /**
     * Prints n lines with stars in descending order:
     * n stars in line 1, n-1 stars in line 2, ... ,
     * 1 star in line n.
     *
     * @param n     the number of lines
     */
    public static void printStarsDesc(int n) {
        for (int i = n; i >= 1; i--) {
            printStarsH(i);
        }
    }

    /**
     * Prints the result according to the input choice and
     * number of stars.
     *
     * @param choice        the input choice.
     * @param numOfStars    the input number of stars.
     */
    public static void printResult(int choice, int numOfStars) {
        switch (choice) {
            case 1:
                printStarsH(numOfStars);
                break;
            case 2:
                printStarsV(numOfStars);
                break;
            case 3:
                printStarsHV(numOfStars);
                break;
            case 4:
                printStarsAsc(numOfStars);
                break;
            case 5:
                printStarsDesc(numOfStars);
                break;
            default:
                System.out.println("Λάθος επιλογή");
                break;
        }
    }
}
