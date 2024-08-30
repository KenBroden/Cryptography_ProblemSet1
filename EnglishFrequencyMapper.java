import java.util.*;

public class EnglishFrequencyMapper {
    public static Map<Character, Character> mapToEnglishFrequencies(Map<Character, Double> frequencyMap) {
        Map<Character, Double> englishFrequencies = new LinkedHashMap<>();
        englishFrequencies.put('a', 0.0817);
        englishFrequencies.put('b', 0.0150);
        englishFrequencies.put('c', 0.0278);
        englishFrequencies.put('d', 0.0425);
        englishFrequencies.put('e', 0.1270);
        englishFrequencies.put('f', 0.0223);
        englishFrequencies.put('g', 0.0202);
        englishFrequencies.put('h', 0.0609);
        englishFrequencies.put('i', 0.0697);
        englishFrequencies.put('j', 0.0015);
        englishFrequencies.put('k', 0.0077);
        englishFrequencies.put('l', 0.0403);
        englishFrequencies.put('m', 0.0241);
        englishFrequencies.put('n', 0.0675);
        englishFrequencies.put('o', 0.0751);
        englishFrequencies.put('p', 0.0193);
        englishFrequencies.put('q', 0.0010);
        englishFrequencies.put('r', 0.0599);
        englishFrequencies.put('s', 0.0633);
        englishFrequencies.put('t', 0.0906);
        englishFrequencies.put('u', 0.0276);
        englishFrequencies.put('v', 0.0098);
        englishFrequencies.put('w', 0.0236);
        englishFrequencies.put('x', 0.0015);
        englishFrequencies.put('y', 0.0197);
        englishFrequencies.put('z', 0.0007);

        // Sort the English frequencies by frequency in descending order
        List<Map.Entry<Character, Double>> englishList = new ArrayList<>(englishFrequencies.entrySet());
        englishList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Create a map to store the decrypted letters
        Map<Character, Character> decryptionMap = new LinkedHashMap<>();

        // Map the most frequent letters in the ciphertext to the most frequent letters in English
        int i = 0;
        for (Map.Entry<Character, Double> entry : frequencyMap.entrySet()) {
            decryptionMap.put(entry.getKey(), englishList.get(i).getKey());
            i++;
        }

        return decryptionMap;
    }
}