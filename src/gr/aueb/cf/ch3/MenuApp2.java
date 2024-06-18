package gr.aueb.cf.ch3;

import java.util.Scanner;

/**
 * Εμφανίζει επαναληπτικά ένα μενού το οποίο
 * επαναλαμβάνεται μέχρι ο χρήστης να δώσει
 * τον αριθμό 5. Για κάθε επιλογή εμφανίζεται
 * το αντίστοιχο feedback. Γίνεται έλεγχος για
 * επιλογή <=0 και >5 οπότε διακόπτεται το πρόγραμμα
 * εμφανίζοντας κατάλληλο μήνυμα.
 */
public class MenuApp2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;

        while (true) {
            System.out.println("1. Εισαγωγή");
            System.out.println("2. Διαγραφή");
            System.out.println("3. Ενημέρωση");
            System.out.println("4. Αναζήτηση");
            System.out.println("5. Έξοδος");
            System.out.println("Παρακαλώ εισάγετε την επιλογή σας (1-5):");
            num = in.nextInt();

            if (num <= 0 || num > 5) {
                System.out.println("Μη έγκυρη επιλογή.");
                continue;
            }

            if (num == 5) {
                System.out.println("Επιλέξατε Έξοδο");
                break;
            }

            if (num == 1) {
                System.out.println("Επιλέξατε Εισαγωγή");
            } else if (num == 2) {
                System.out.println("Επιλέξατε Διαγραφή");
            } else if (num == 3) {
                System.out.println("Επιλέξατε Ενημέρωση");
            } else { // num == 4
                System.out.println("Επιλέξατε Αναζήτηση");
            }
        }
        System.out.println("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή!");
    }
}
