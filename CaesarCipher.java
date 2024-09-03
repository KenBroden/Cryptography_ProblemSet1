public class CaesarCipher {

    // Encrypts text using a shift specified by the user
    public static String applyShift(String input, int shift) {
        StringBuilder shiftedText = new StringBuilder();

        // Shift each letter in the input text
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shiftedChar = (char) ((c - base + shift) % 26 + base);
                shiftedText.append(shiftedChar); // Append shifted letter
            } else {
                shiftedText.append(c); // Keep non-letter characters as is
            }
        }

        return shiftedText.toString();
    }
}