package gr.aueb.cf.ch10;

import java.util.Scanner;

/**
 * Implementation of a program for managing the seats' bookings
 * and cancellations for a theatre. The theatre has 30 rows and
 * 12 columns and each seat is described by a letter for the
 * column and a number for the row.
 * For example, the seat "C2" is in the second row and third
 * column.
 */
public class Project05 {

    static boolean[][] theatre = new boolean[30][12];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String seat = "";
        int column = 0;
        int row = 0;

        while (true) {
            try {
                print(theatre);
                System.out.println("Please choose a seat (Q to Quit)");
                seat = in.nextLine().toUpperCase();
                if (seat.equals("Q")) break;
                column = (int) seat.charAt(0) - 65;
                row = Integer.parseInt(seat.substring(1)) - 1;
                if (theatre[row][column] == false) {
                    book(row, column);
                } else cancel(row, column);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("The seat you have chosen is not valid.");
            }
        }
    }

    /**
     * Books a non-booked seat. The seat is defined
     * by its row and column.
     *
     * @param row       the row of the seat.
     * @param column    the column of the seat.
     */
    public static void book(int row, int column) {
        theatre[row][column] = true;
    }

    /**
     * Cancels the booking of a seat. The seat is
     * defined by its row and column.
     *
     * @param row       the row of the seat.
     * @param column    the column of the seat.
     */
    public static void cancel(int row, int column) {
        theatre[row][column] = false;
    }

    /**
     * Traverses a two-dim array and prints its
     * elements.
     *
     * @param arr       the source array.
     */
    public static void print(boolean[][] arr) {
        for (boolean[] row : arr) {
            for (boolean col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
