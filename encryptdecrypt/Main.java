package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String algorithm = "shift";
        String command = "enc";
        String message = "";
        int key = 0;
        String input = "";
        String output = "";

        int index = 0;
        while (index < args.length) {
            switch (args[index]) {
                case "-alg":
                    algorithm = args[++index];
                    break;
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

        Translator algo;

        if (algorithm.equals("unicode")) {
            if (command.equals("enc")) {
                algo = new UnicodeEncode(message, input, output, key);
            } else {
                algo = new UnicodeDecode(message, input, output, key);
            }
        } else {
            if (command.equals("enc")) {
                algo = new CaesarEncode(message, input, output, key);
            } else {
                algo = new CaesarDecode(message, input, output, key);
            }
        }

        algo.doWork();
    }
}
