import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.putIfAbsent(c, 0);
            charCount.put(c, charCount.get(c) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()) {
            int count = charCount.getOrDefault(c, 0);
            for (int i = 0; i < count; i++) sb.append(c);
            charCount.remove(c);
        }

        for (char key : charCount.keySet()) {
            int count = charCount.get(key);
            for (int i = 0; i < count; i++) sb.append(key);
        }
        
        return sb.toString();
    }
}