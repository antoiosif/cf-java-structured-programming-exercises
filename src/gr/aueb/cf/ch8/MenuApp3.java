package gr.aueb.cf.ch8;

import java.util.Scanner;

/**
 * Prints a menu of 5 choices for the user to
 * choose from and prints the user's choice. The
 * process is repeated until the user inserts 5
 * (5 is exit).
 */
public class MenuApp3 {

    public static void main(String[] args) {
        int choice = 0;

        do {
           try {
               printMenu();
               choice = getChoice();
               if (choice == -1) {
                   System.out.println("Λάθος επιλογή. Παρακαλώ εισάγετε έναν αριθμό 1-5");
                   continue;
               }
               printChoice(choice);
           } catch (IllegalArgumentException e) {
               System.out.println("Λάθος επιλογή. Παρακαλώ εισάγετε έναν αριθμό 1-5");
           }
        } while (choice != 5);
        System.out.println("Ευχαριστούμε!");
    }

    /**
     * Prints a CRUD menu.
     */
    public static void printMenu() {
        System.out.println("1. Εισαγωγή");
        System.out.println("2. Διαγραφή");
        System.out.println("3. Αναζήτηση");
        System.out.println("4. Ενημέρωση");
        System.out.println("5. Έξοδος");
        System.out.println("Δώστε αριθμό επιλογής:");
    }

    /**
     * Gets the user's choice (an integer).
     *
     * @return      the integer if the input is an integer,
     *              -1 otherwise.
     */
    public static int getChoice() {
        Scanner in = new Scanner(System.in);

        if (!in.hasNextInt()) {
            in.nextLine();
            return -1;
        }
        return in.nextInt();
    }

    /**
     * Prints a message relevant to the user's choice.
     *
     * @param choice                        the input integer.
     * @throws IllegalArgumentException     if the integer is not in the range 1-5.
     */
    public static void printChoice(int choice) throws IllegalArgumentException {
        try {
            switch (choice) {
                case 1 :
                    System.out.println("Επιλέξατε \"Εισαγωγή\"");
                    break;
                case 2 :
                    System.out.println("Επιλέξατε \"Διαγραφή\"");
                    break;
                case 3 :
                    System.out.println("Επιλέξατε \"Αναζήτηση\"");
                    break;
                case 4 :
                    System.out.println("Επιλέξατε \"Ενημέρωση\"");
                    break;
                case 5 :
                    System.out.println("Επιλέξατε \"Έξοδο\"");
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
