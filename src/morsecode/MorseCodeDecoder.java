package morsecode;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        morseCode = removeStartingAndEndingSpaces(morseCode);
        String decoded = "";
        String nextMorseLetter = "";
        for (int i = 0; i < morseCode.length(); i++) {
            if (i == morseCode.length() - 1) {
                nextMorseLetter = nextMorseLetter.concat(morseCode.substring(i, i + 1));
                decoded = decoded.concat(decodeLetter(nextMorseLetter));
//                decoded = decoded.concat(MorseCode.get(nextMorseLetter));
            }
            if (morseCode.substring(i, i + 1).equals(" ")) {
                decoded = decoded.concat(decodeLetter(nextMorseLetter));
//                decoded = decoded.concat(MorseCode.get(nextMorseLetter));
                if (i < morseCode.length() - 1 && morseCode.substring(i + 1, i + 2).equals(" ")) {
                    decoded = decoded.concat(" ");
                    i = i + 2;
                }
                nextMorseLetter = "";
            } else {
                nextMorseLetter = nextMorseLetter.concat(morseCode.substring(i, i + 1));
            }
        }
        return decoded;
    }

    public static void main(String[] args) {
        String decoded = decode(".... . -.--   .--- ..- -.. .");
        String decoded2 = decode(" . ");

        System.out.println("decode message is " + decoded2);
    }

    static String decodeLetter(String morseLetter) {
        switch (morseLetter) {
            case ".-":
                return "A";
            case "-··.":
                return "B";
            case "-.-.":
                return "C";
            case "-..":
                return "D";
            case ".":
                return "E";
            case "..-.":
                return "F";
            case "--.":
                return "G";
            case "....":
                return "H";
            case "..":
                return "I";
            case ".---":
                return "J";
            case "-.-":
                return "K";
            case ".-..":
                return "L";
            case "--":
                return "M";
            case "-.":
                return "N";
            case "---":
                return "O";
            case ".--.":
                return "P";
            case "--.-":
                return "Q";
            case ".-.":
                return "R";
            case "...":
                return "S";
            case "-":
                return "T";
            case "..-":
                return "U";
            case "...-":
                return "V";
            case ".--":
                return "W";
            case "-..-":
                return "X";
            case "-.--":
                return "Y";
            case "--.·":
                return "Z";
            default:
                return "";
        }

    }

    static String removeStartingAndEndingSpaces(String morseCode) {
        if (morseCode.length() == 0) {
            return morseCode;
        }
        while ((String.valueOf(morseCode.charAt(0))).equals(" ")) {
            morseCode = morseCode.substring(1);
        }
        while (morseCode.length()>1 && (String.valueOf(morseCode.charAt(morseCode.length() - 1))).equals(" ") ) {
            morseCode = morseCode.substring(0, morseCode.length() - 1);
        }
        return morseCode;

    }

}