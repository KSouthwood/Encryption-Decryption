package encryptdecrypt;

import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        String command = "enc";
        String message = "";
        int    key     = 0;

        int index = 0;
        while (index < args.length) {
            switch (args[index]) {
                case "-mode":
                    command = args[++index];
                    break;
                case "-key":
                    key = Integer.parseInt(args[++index]);
                    break;
                case "-data":
                    message = args[++index];
                    break;
                default:
                    break;
            }
            ++index;
        }

        takeAction(command, message, key);
    }

    private static void takeAction(String command, String message, int key) {
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
