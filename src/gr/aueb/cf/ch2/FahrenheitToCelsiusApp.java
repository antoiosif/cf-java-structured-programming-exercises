package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Μετατρέπει ακέραιες θερμοκρασίες Φαρενάιτ,
 * που εισάγει ο χρήστης στο standard input,
 * στην κλίμακα Κελσίου.
 */
public class FahrenheitToCelsiusApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fahrenheitTemp = 0;
        int celsiusTemp = 0;

        System.out.println("Please insert an integer temperature (in Fahrenheit)");
        fahrenheitTemp = in.nextInt();
        celsiusTemp = 5 * (fahrenheitTemp - 32) / 9;

        System.out.printf("%d\u2109 = %d\u2103", fahrenheitTemp, celsiusTemp);
    }
}
