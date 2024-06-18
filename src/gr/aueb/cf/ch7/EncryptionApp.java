package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Encrypts a String inserted by the user by shifting
 * the initial characters key-positions in the ASCII
 * code.
 * The key is 1.
 */
public class EncryptionApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String plaintext;
        String ciphertext;
        final int KEY = 1;

        System.out.println("Please insert the message you want to encrypt: ");
        plaintext = in.nextLine();
        ciphertext = encrypt(plaintext, KEY);
        System.out.println("Encrypted text: " + ciphertext);
    }

    /**
     * Encrypts a String by shifting each character
     * key-positions in the ASCII code.
     *
     * @param plaintext     the String to be encrypted.
     * @param key           the secret key.
     * @return              the encrypted String.
     */
    public static String encrypt(String plaintext, int key) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            ciphertext.append(getEncryptedChar(plaintext.charAt(i), key));
        }

        return ciphertext.toString();
    }

    /**
     * Encrypts a character by shifting it key-positions
     * in the ASCII code.
     *
     * @param ch    the character to be encrypted.
     * @param key   the secret key.
     * @return      the encrypted character.
     */
    public static char getEncryptedChar(char ch, int key) {
        return (char) ((int) ch + key);
    }
}
