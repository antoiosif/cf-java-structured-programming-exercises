package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Ο χρήστης εισάγει ένα έτος στο standard in,
 * το πρόγραμμα αποφαίνεται αν είναι δίσεκτο ή όχι
 * και εμφανίζει το αποτέλεσμα στην οθόνη.
 * Εάν ο χρήστης δε δώσει έγκυρο έτος ( > 0)
 * το πρόγραμμα διακόπτεται και εμφανίζεται
 * κατάλληλο μήνυμα.
 */
public class LeapYearApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = 0;
        boolean isLeapYear = false;

        System.out.println("Please insert a year:");
        year = in.nextInt();

        // ελέγχεται αν ο χρήστης έδωσε έγκυρο έτος
        if (year <= 0) {
            System.out.println("Error in input data. The year should be > 0.");
            System.exit(1);
        }

        isLeapYear = ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0;

        if (isLeapYear) {
            System.out.println("The year " + year + " is a leap year.");
        } else {
            System.out.println("The year " + year + " is not a leap year.");
        }
        System.out.println("Thank you for using our app!");
    }
}
