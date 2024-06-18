package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Decrypts an encrypted String inserted by the
 * user by shifting each character key-positions
 * in the ASCII code.
 * The key is -1.
 */
public class DecryptionApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ciphertext;
        String plaintext;
        final int KEY = -1;

        System.out.println("Please insert the message you want to decrypt: ");
        ciphertext = in.nextLine();
        plaintext = decrypt(ciphertext, KEY);
        System.out.println("Decrypted text: " + plaintext);
    }

    /**
     * Decrypts a String by shifting each character
     * key-positions in the ASCII code.
     *
     * @param ciphertext    the String to be decrypted.
     * @param key           the secret key.
     * @return              the decrypted String.
     */
    public static String decrypt(String ciphertext, int key) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            plaintext.append(getDecryptedChar(ciphertext.charAt(i), key));
        }

        return plaintext.toString();
    }

    /**
     * Decrypts a character by shifting it key-positions
     * in the ASCII code.
     *
     * @param ch    the character to be decrypted.
     * @param key   the secret key.
     * @return      the decrypted character.
     */
    public static char getDecryptedChar(char ch, int key) {
        return (char) ((int) ch + key);
    }
}
