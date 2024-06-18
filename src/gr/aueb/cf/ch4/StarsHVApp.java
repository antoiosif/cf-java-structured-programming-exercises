package gr.aueb.cf.ch4;

import java.util.Scanner;

/**
 * Ο χρήστης δίνει το πλήθος (n) των
 * stars και το πρόγραμμα εμφανίζει
 * n stars οριζόντια και n stars κάθετα
 * (nxn).
 */
public class StarsHVApp {

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
            for (int j = 1; j <= starsNum; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
