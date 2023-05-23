import java.util.*;

public class CountOccurrenceOfChars {
    public static Character countChars(String message, String alphabet) {
        //HashMap char as a key and occurrence as a value
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = message.length() - 1; i >= 0; i--) {
            char c = message.charAt(i);
            int charPosition = alphabet.indexOf(c);
               if (charPosition < 0){continue;}
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

        return keys.get(0);
    }
}
