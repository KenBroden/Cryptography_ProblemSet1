public class CaesarCipher {
    public static String applyShift(String input, int shift) {
        StringBuilder shiftedText = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shiftedChar = (char) ((c - base + shift) % 26 + base);
                shiftedText.append(shiftedChar);
            } else {
                shiftedText.append(c);
            }
        }

        return shiftedText.toString();
    }
}