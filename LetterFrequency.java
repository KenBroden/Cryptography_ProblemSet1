import java.util.*;

public class LetterFrequency {
    public static Map<Character, Double> calculateFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int totalLetters = 0;

        // Calculate frequency of each character
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                totalLetters++;
            }
        }

        // Convert counts to ratios
        Map<Character, Double> ratioMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            ratioMap.put(entry.getKey(), entry.getValue() / (double) totalLetters);
        }

        // Sort the map by ratio in descending order
        List<Map.Entry<Character, Double>> list = new ArrayList<>(ratioMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Convert sorted list back to a map
        Map<Character, Double> sortedRatioMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Double> entry : list) {
            sortedRatioMap.put(entry.getKey(), entry.getValue());
        }

        return sortedRatioMap;
    }
}