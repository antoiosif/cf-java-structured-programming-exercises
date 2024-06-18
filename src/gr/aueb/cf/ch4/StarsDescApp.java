package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Ο χρήστης δίνει το πλήθος (n) των
 * stars και το πρόγραμμα τα εμφανίζει
 * σε φθίνουσα σειρά: n stars στη
 * 1η σειρά, n-1 στη 2η σειρά, κοκ,
 * 1 star στη n-οστή σειρά.
 */
public class StarsDescApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int starsNum = 0;

        System.out.println("Please insert stars' number (int):");
        starsNum = in.nextInt();

        if (starsNum <= 0) {
            System.out.println("Stars' number should be > 0.");
            System.exit(1);
        }

        for (int i = starsNum; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
