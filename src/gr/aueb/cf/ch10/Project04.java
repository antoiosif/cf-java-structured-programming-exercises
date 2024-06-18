package gr.aueb.cf.ch10;

import java.util.Scanner;

/**
 * Implementation of the game 'Tic-tac-toe'.
 */
public class Project04 {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] dashboard = {{'_', '_', '_'},          // underscores are used for better visibility of the dashboard
                              {'_', '_', '_'},
                              {'_', '_', '_'}};
        int[] positionCoordinates;
        int emptyPositions = 9;      // 3 x 3 = 9
        String[] playerSettings = {"Player 1", "X"};    // 0: player's name, 1: player's mark

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("-----------------------");
        while (true) {
            System.out.println(playerSettings[0] + " is playing!");
            System.out.println("Choose position x,y (x for row, y for column ex. 1,2)");
            print(dashboard);
            positionCoordinates = getPosition();
            if (positionCoordinates.length == 0) {
                System.out.println("Error in input position.");
                continue;
            }
            if (!isEmptyPosition(dashboard, positionCoordinates)) {
                System.out.println("This position is already taken...");
                continue;
            }
            markPosition(dashboard, positionCoordinates, playerSettings[1].charAt(0));
            if (isInRow(dashboard, positionCoordinates, playerSettings[1].charAt(0))) {
                System.out.println(playerSettings[0] + " Congratulations! You win!");
                print(dashboard);
                break;
            }
            emptyPositions--;
            if (emptyPositions == 0) {
                System.out.println("No empty positions left...");
                System.out.println("Player 1 and Player 2 you are even!");
                print(dashboard);
                break;
            }
            changePlayer(playerSettings);
        }
    }

    /**
     * Traverses a two-dim array NxN and prints its elements,
     * while formatting the output to enumerate the rows
     * and columns. The enumeration starts from 1 (instead
     * of 0) so that it is user-friendly.
     *
     * @param arr   the source array.
     */
    public static void print(char[][] arr) {
        int n = arr.length;
        int j = 1;

        // enumerate the columns
        System.out.print("  ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        // enumerate the rows
        for (char[] row : arr) {
            System.out.print(j++ + " ");
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /**
     * Gets the player's input, validates it and, if it
     * is valid, converts it to an array of two integers
     * which represent the coordinates of the position
     * on the dashboard where the player wants its mark.
     * The player's input has to be in the form: "x,y"
     * (ex. "1,2").
     *
     * @return      an array of two integers if the
     *              input is valid, otherwise an array
     *              of zero length.
     */
    public static int[] getPosition() {
        int[] arrayToReturn = new int[2];
        int position = 0;

        String[] tokens = in.nextLine().split(",");
        if (tokens.length != 2) return new int[0];
        for (int i = 0; i < tokens.length; i++) {
            if (isInt(tokens[i])) position = Integer.parseInt(tokens[i]);
            if (isValidNumber(position)) {
                arrayToReturn[i] = position - 1;    // position for the users starts from 1 (instead of 0)
            } else return new int[0];
        }
        return arrayToReturn;
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
     * number has to be in the value range 1-3.
     *
     * @param num   the number to be validated.
     * @return      true if the number is in the
     *              value range 1-3, false otherwise.
     */
    public static boolean isValidNumber(int num) {
        return num >= 1 && num <= 3;
    }

    /**
     * Checks if a specific element of a two-dim array
     * is empty (to be empty, its value should be '_'
     * and not 'X' or 'O'). The element is defined by
     * the contents of an array of two integers.
     *
     * @param arr           the source array.
     * @param position      the int array that defines the element.
     * @return              true if the element is empty, false
     *                      otherwise.
     */
    public static boolean isEmptyPosition(char[][] arr, int[] position) {
        return arr[position[0]][position[1]] == '_';
    }

    /**
     * Changes the value of a specific element of a two-dim
     * array with a new one. The element's to be changed
     * coordinates are defined by an array of two integers.
     *
     * @param dashboard     the source array.
     * @param position      the int array that defines the
     *                      element to be changed.
     * @param playerMark    the new value of the element.
     */
    public static void markPosition(char[][] dashboard, int[] position, char playerMark) {
        dashboard[position[0]][position[1]] = playerMark;
    }

    /**
     * Decides if there are N elements in a row with a
     * specific value in a two-dim array NxN (horizontally,
     * vertically or diagonally).
     *
     * @param arr       the source array.
     * @param mark      the value that the elements need to
     *                  have.
     * @return          true if there are N elements in a
     *                  row with the specific value, false
     *                  otherwise.
     */
    public static boolean isInRow(char[][] arr, int[] position, char mark) {
        return isInRowHorizontally(arr, position, mark) || isInRowVertically(arr, position, mark)
                || isInRowDiagonally(arr, position, mark);
    }

    /**
     * Traverses a row in a two-dim array NxN to decide if
     * there are N elements in a row with a specific value.
     *
     * @param arr       the source array.
     * @param position  the int array that defines the row to
     *                  be checked.
     * @param mark      the value that the elements need
     *                  to have.
     * @return          true if there are N elements in a
     *                  row with the specific value, false
     *                  otherwise.
     */
    public static boolean isInRowHorizontally(char[][] arr, int[] position, char mark) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[position[0]][i] != mark) return false;
        }
        return true;
    }

    /**
     * Traverses a column in a two-dim array NxN to decide if
     * there are N elements in a row with a specific
     * value.
     *
     * @param arr       the source array.
     * @param position  the int array that defines the column
     *                  to be checked.
     * @param mark      the value that the elements need
     *                  to have.
     * @return          true if there are N elements in a
     *                  row with the specific value, false
     *                  otherwise.
     */
    public static boolean isInRowVertically(char[][] arr, int[] position, char mark) {
        for (char[] row : arr) {
            if (row[position[1]] != mark) return false;
        }
        return true;
    }

    /**
     * Traverses a two-dim array NxN to decide if there are
     * N elements in a row diagonally with a specific value.
     * The method checks both the diagonals of the two-dim
     * array.
     *
     * @param arr       the source array.
     * @param mark      the value that the elements need
     *                  to have.
     * @return          true if there are N elements in a
     *                  row with the specific value, false
     *                  otherwise.
     */
    public static boolean isInRowDiagonally(char[][] arr, int[] position, char mark) {
        int n = arr.length;
        int count = 0;

        // diagonal 1
        if (position[0] == position [1]) {
            for (int i = 0; i < n; i++) {
                if ((arr[i][i]) == mark) count++;
                else break;
            }
            if (count == n) return true;
            else count = 0;
        }

        // diagonal 2
        if ((position[0] + position [1]) == (n - 1)) {
            for (int i = 0; i < n; i++) {
                if ((arr[i][(n - 1) - i]) == mark) count++;
                else break;
            }
        }
        return (count == n);
    }

    /**
     * Changes the values of a String array that represent
     * the settings for a player and thus changes the player.
     * The first element is the player's name (ex. "Player 1")
     * and the second is the player's mark (ex. "X").
     *
     * @param playerSettings    the source array.
     */
    public static void changePlayer(String[] playerSettings) {
        playerSettings[0] = (playerSettings[0].equals("Player 1")) ? "Player 2" : "Player 1";
        playerSettings[1] = (playerSettings[1].equals("X")) ? "O" : "X";
    }
}
