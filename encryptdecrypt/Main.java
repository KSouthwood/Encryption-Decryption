package encryptdecrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        String command = "enc";
        String message = "";
        int    key     = 0;
        String input   = "";
        String output  = "";

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
                    input = "line";
                    break;
                case "-in":
                    if (input.isBlank()) {
                        input = args[++index];
                    }
                    break;
                case "-out":
                    output = args[++index];
                    break;
                default:
                    break;
            }
            ++index;
        }

        if (!(input.isBlank() || input.equals("line"))) {
           message = readFile(input);
        }

        if (message == null) {
            return;
        }

        String result = takeAction(command, message, key);

        if (result == null) {
            return;
        }

        if (output.isBlank()) {
            System.out.println(result);
        } else {
            writeFile(output, result);
        }
    }

    private static String takeAction(String command, String message, int key) {
        switch (command) {
            case "enc":
                return encode(message, key);
            case "dec":
                return decode(message, key);
            default:
                System.out.println("Error: Unknown -mode.");
                return null;
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

    private static String readFile(String infile) {
        try (FileInputStream data = new FileInputStream(infile)) {
            StringBuilder msg = new StringBuilder();
            for (int line = data.read(); line != -1; line = data.read()) {
                msg.append((char) line);
            }
            return msg.toString();
        } catch (IOException e) {
            System.out.println("Error: file not found");
            return null;
        }
    }

    private static void writeFile(String outfile, String message) {
        try (FileOutputStream out = new FileOutputStream(outfile)) {
            for (char ch : message.toCharArray()) {
                out.write(ch);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
