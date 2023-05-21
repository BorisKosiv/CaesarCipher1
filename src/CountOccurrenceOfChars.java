import java.util.*;

public class CountOccurrenceOfChars {
    public String countOccurrenceOfChars(String message, int index) {
        //HashMap char as a key and occurrence as a value
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = message.length() - 1; i >= 0; i--) {

            if (charCount.containsKey(message.charAt(i))) {
                int count = charCount.get(message.charAt(i));
                charCount.put(message.charAt(i), ++count);
            } else {
                charCount.put(message.charAt(i), 1);
            }

        }
        int max = Collections.max(charCount.values());

        List<Character> keys = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {

            if (entry.getValue() == max) {
                keys.add(entry.getKey());
            }
        }
        System.out.println("Print characters which mostly occur in the text:");
        System.out.println(keys.toString());
        return String.valueOf(keys.get(index));
    }
}
