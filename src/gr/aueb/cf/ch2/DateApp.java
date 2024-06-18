package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Διαβάζει από το χρήστη 3 ακέραιους αριθμούς
 * που αναπαριστούν ημέρα, μήνα, έτος και
 * εμφανίζει την ημερομηνία σε μορφή ΗΗ/ΜΜ/ΕΕ.
 */
public class DateApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inputDay = 0;
        int inputMonth = 0;
        int inputYear = 0;

        System.out.println("Please insert 3 integers for day, month and year:");
        inputDay = in.nextInt();
        inputMonth = in.nextInt();
        inputYear = in.nextInt();

        System.out.printf("Date: %02d/%02d/%02d", inputDay, inputMonth, (inputYear % 100));
    }
}
