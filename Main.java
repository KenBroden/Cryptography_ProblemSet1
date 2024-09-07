import java.util.*;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("all")
        String input = "xultpaajcxitltlxaarpjhtiwtgxktghidhipxciwtvgtpilpit\r\n" + //
                "ghlxiwiwtxgqadds";

        // Apply Caesar Cipher with different shifts.  **1.2 Decryption Strategy**
        System.out.println("Trying different Caesar cipher shifts:");
        for (int shift = 1; shift <= 26; shift++) {
            String shiftedText = CaesarCipher.applyShift(input, shift);
            System.out.println("Shift " + shift + ":\n" + shiftedText);
        }

        Map<Character, Double> frequencyMap = LetterFrequency.calculateFrequency(input);

        // Print the frequency ratio of each letter
        for (Map.Entry<Character, Double> entry : frequencyMap.entrySet()) {
            System.out.printf("%c: %.4f%n", entry.getKey(), entry.getValue());
        }

        // Map to English frequencies
        Map<Character, Character> decryptionMap = EnglishFrequencyMapper.mapToEnglishFrequencies(frequencyMap);

        // Print the decryption map
        System.out.println("Ciphertext Letter\tDecrypted Letter");
        for (Map.Entry<Character, Character> entry : decryptionMap.entrySet()) {
            System.out.printf("%c\t\t\t%c%n", entry.getKey(), entry.getValue());
        }

        // Decrypt the text
        String decryptedText = TextDecryptor.decryptText(input, decryptionMap);
        System.out.println("\nDecrypted Text:\n" + decryptedText);

        // Allow manual adjustments
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter a ciphertext letter to change (or 'exit' to finish): ");
            String cipherInput = scanner.nextLine();
            if (cipherInput.equalsIgnoreCase("exit")) {
                break;
            }
            if (cipherInput.length() != 1 || !Character.isLetter(cipherInput.charAt(0))) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }
            char cipherChar = Character.toLowerCase(cipherInput.charAt(0));

            System.out.println("Enter the corresponding plaintext letter: ");
            String plainInput = scanner.nextLine();
            if (plainInput.length() != 1 || !Character.isLetter(plainInput.charAt(0))) {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }
            char plainChar = Character.toLowerCase(plainInput.charAt(0));

            TextDecryptor.updateDecryptionMap(decryptionMap, cipherChar, plainChar);

            // Print the updated decryption map
            System.out.println("Updated Decryption Map:");
            for (Map.Entry<Character, Character> entry : decryptionMap.entrySet()) {
                System.out.printf("%c\t\t\t%c%n", entry.getKey(), entry.getValue());
            }

            // Decrypt the text with the updated map
            decryptedText = TextDecryptor.decryptText(input, decryptionMap);
            System.out.println("\nUpdated Decrypted Text:\n" + decryptedText);
        }

        scanner.close();

    }
}