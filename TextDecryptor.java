import java.util.*;

public class TextDecryptor {
    public static String decryptText(String input, Map<Character, Character> decryptionMap) {
        StringBuilder decryptedText = new StringBuilder();

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
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }

    public static void updateDecryptionMap(Map<Character, Character> decryptionMap, char cipherChar, char plainChar) {
        decryptionMap.put(cipherChar, plainChar);
    }
}