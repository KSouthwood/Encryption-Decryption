package encryptdecrypt;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        getInputs();
    }

    private static void getInputs() {
        Scanner input = new Scanner(System.in);

        String command = input.nextLine();
        String message = input.nextLine();
        int    key     = input.nextInt();

        switch (command) {
            case "enc":
                System.out.println(encode(message, key));
                break;
            case "dec":
                System.out.println(decode(message, key));
                break;
            default:
                System.out.println("Unknown command.");
                break;
        }
    }

    private static String encodeCaesar(String encode, int key) {
        StringBuilder encoded = new StringBuilder();
        
        for (char letter : encode.toCharArray()) {
            if (Character.isLetter(letter)) {
                encoded.append((char) ((((letter - 'a') + key) % 26) + 'a'));
            } else {
                encoded.append(letter);
            }
        }
        
        return encoded.toString();
    }

    private static String encode(String msg, int key) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            encoded.append((char) (ch + key));
        }

        return encoded.toString();
    }

    private static String decode(String msg, int key) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            encoded.append((char) (ch - key));
        }

        return encoded.toString();
    }

}
