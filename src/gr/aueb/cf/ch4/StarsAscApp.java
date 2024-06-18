package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Ο χρήστης δίνει το πλήθος (n) των
 * stars και το πρόγραμμα τα εμφανίζει
 * σε αύξουσα σειρά: 1 star στη
 * 1η σειρά, 2 στη 2η σειρά, κοκ,
 * n stars στη n-οστή σειρά.
 */
public class StarsAscApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int starsNum = 0;

        System.out.println("Please insert stars' number (int):");
        starsNum = in.nextInt();

        if (starsNum <= 0) {
            System.out.println("Stars' number should be > 0.");
            System.exit(1);
        }

        for (int i = 1; i <= starsNum; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
