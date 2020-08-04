package encryptdecrypt;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String toEncode = input.nextLine();
        int key = input.nextInt();
        
        System.out.println(encodeCaesar(toEncode, key));
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
}
