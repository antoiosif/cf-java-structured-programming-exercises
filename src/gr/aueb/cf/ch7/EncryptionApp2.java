package gr.aueb.cf.ch7;

import java.util.Scanner;

public class EncryptionApp2 {

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

    public static String encrypt(String plaintext, int KEY) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            ciphertext.append(getEncryptedChar(plaintext.charAt(i), KEY));
        }

        return ciphertext.toString();
    }


    /**
     * Encrypts a character with its next in the
     * ASCII code.
     *
     * @param ch    the character to be encrypted.
     * @return      the encrypted character.
     */
    public static char getEncryptedChar(char ch, int KEY) {
        return (char) ((int) ch + KEY);
    }
}
