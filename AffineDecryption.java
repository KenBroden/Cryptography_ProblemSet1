public class AffineDecryption {

    // Decrypts text using the Affine Cipher decryption strategy
    public static String decryptText(String input, int a, int b) {
        StringBuilder decryptedText = new StringBuilder();
        int aInverse = modInverse(a, 26);

        // Decrypt each letter in the input text
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char decryptedChar = (char) ((aInverse * ((c - 'a' - b + 26) % 26)) % 26 + 'a');
                decryptedText.append(decryptedChar); // Append decrypted letter
            }
        }

        return decryptedText.toString();
    }

    // Calculate the modular multiplicative inverse of a number
    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("No modular inverse exists for a = " + a + " and m = " + m);
    }

    public static void main(String[] args) {
        String ciphertext = "falszztysyjzyjkywjrztyjztyynaryjkyswarztyegyyj";
        int a = 7;
        int b = 22;
        String decryptedText = decryptText(ciphertext, a, b);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}