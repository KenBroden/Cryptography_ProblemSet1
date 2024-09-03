import java.util.*;

public class TextDecryptor {

    // Decrypts text using a decryption map
    public static String decryptText(String input, Map<Character, Character> decryptionMap) {
        StringBuilder decryptedText = new StringBuilder();

        // Decrypt each letter in the input text
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerCaseChar = Character.toLowerCase(c);
                char decryptedChar = decryptionMap.getOrDefault(lowerCaseChar, lowerCaseChar);
                if (Character.isUpperCase(c)) {
                    decryptedText.append(Character.toUpperCase(decryptedChar));
                } else {
                    decryptedText.append(decryptedChar);
                }
            } else {
                decryptedText.append(c); // Keep non-letter characters as is
            }
        }

        return decryptedText.toString();
    }

    // Update the decryption map with a new mapping
    public static void updateDecryptionMap(Map<Character, Character> decryptionMap, char cipherChar, char plainChar) {
        decryptionMap.put(cipherChar, plainChar);
    }
}