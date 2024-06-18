package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * Prints a menu with 6 choices for the user
 * to choose from, and uses methods to implement
 * them. The process is repeated until the user
 * terminates it.
 */
public class StarsMenuApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int n = 0;

        while (true) {
            printMenu();
            choice = in.nextInt();

            if (choice < 1 || choice > 6) {
                System.out.println("Λάθος επιλογή. Παρακαλώ επιλέξτε 1-6 από τα παρακάτω.");
                continue;
            }

            if (choice == 6) {
                System.out.println("Επιλέξατε έξοδο.\nΕυχαριστούμε που χρησιμοποιήσατε την εφαρμογή!");
                break;
            }

            do {
                System.out.println("Δώστε αριθμό για αστεράκια:");
                n = in.nextInt();
            } while (!isValid(n));

            printResult(choice, n);
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
     * Checks if an integer is valid and if not,
     * prints an appropriate message to the user.
     * To be valid, the integer should be > 0.
     *
     * @param n     the integer
     * @return      true if integer > 0, false if integer <= 0
     */
    public static boolean isValid(int n) {
        if (n <= 0) {
            System.out.println("Ο αριθμός πρέπει να είναι μεγαλύτερος από 0.");
            return false;
        } else {
            return true;
        }
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
            System.out.println();
        }
    }

    public static void printResult(int choice, int n) {
        switch (choice) {
            case 1:
                printStarsH(n);
                break;
            case 2:
                printStarsV(n);
                break;
            case 3:
                printStarsHV(n);
                break;
            case 4:
                printStarsAsc(n);
                break;
            case 5:
                printStarsDesc(n);
                break;
            default:
                System.out.println("Λάθος επιλογή");
                break;
        }
    }
}
