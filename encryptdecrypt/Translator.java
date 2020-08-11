package encryptdecrypt;

import java.io.*;

public abstract class Translator {
    String message;
    String input;
    String output;
    int key;

    char[] source;
    StringBuilder result = new StringBuilder();

    public Translator(String msg, String in, String out, int key) {
        this.message = msg;
        this.input   = in;
        this.output  = out;
        this.key     = key;
    }

    public void doWork() {
        getMessage();
        if (source.length > 0) {
            translate();
            sendMessage();
        }
    }

    private void getMessage() {
        if (input.isBlank() || input.equals("line")) {
            source = message.toCharArray();
        } else {
            readFile();
        }
    }

    protected abstract void translate();

    private void sendMessage() {
        if (output.isBlank()) {
            System.out.println(result);
        } else {
            writeFile();
        }
    }

    private void readFile() {
        StringBuilder data_in = new StringBuilder();

        try (BufferedReader data = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = data.readLine()) != null) {
                data_in.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        source = data_in.toString().toCharArray();
    }

    private void writeFile() {
        try (BufferedWriter data = new BufferedWriter(new FileWriter(output))) {
            data.append(result);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

class CaesarEncode extends Translator {
    public CaesarEncode(String msg, String in, String out, int key) {
        super(msg, in, out, key);
    }

    @Override
    protected void translate() {
        for (char ch : source) {
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    result.append((char) ((((ch - 'a') + key) % 26) + 'a'));
                } else {
                    result.append((char) ((((ch - 'A') + key) % 26) + 'A'));
                }
            } else {
                result.append(ch);
            }
        }
    }
}

class CaesarDecode extends Translator {
    public CaesarDecode(String msg, String in, String out, int key) {
        super(msg, in, out, key);
    }

    @Override
    protected void translate() {
        for (char ch : source) {
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    result.append((char) ((((ch - 'a') + (26 - key)) % 26) + 'a'));
                } else {
                    result.append((char) ((((ch - 'A') + (26 - key)) % 26) + 'A'));
                }
            } else {
                result.append(ch);
            }
        }
    }
}

class UnicodeEncode extends Translator {
    public UnicodeEncode(String msg, String in, String out, int key) {
        super(msg, in, out, key);
    }

    @Override
    protected void translate() {
        for (char ch : source) {
            result.append((char) (ch + key));
        }
    }
}

class UnicodeDecode extends Translator {
    public UnicodeDecode(String msg, String in, String out, int key) {
        super(msg, in, out, key);
    }

    @Override
    protected void translate() {
        for (char ch : source) {
            result.append((char) (ch - key));
        }
    }
}