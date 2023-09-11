import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        HashMap<Character, Integer> charOccurrences1 = new HashMap<>();
        HashMap<Character, Integer> charOccurrences2 = new HashMap<>();
        for (char c : word1.toCharArray()) charOccurrences1.put(c, charOccurrences1.getOrDefault(c, 0) + 1);
        for (char c : word2.toCharArray()) charOccurrences2.put(c, charOccurrences2.getOrDefault(c, 0) + 1);
        if (charOccurrences1.values().size() != charOccurrences2.values().size()) return false;
        if (!charOccurrences1.keySet().equals(charOccurrences2.keySet())) return false;
        ArrayList<Integer> val1 = new ArrayList<>(charOccurrences1.values());
        ArrayList<Integer> val2 = new ArrayList<>(charOccurrences2.values());
        val1.sort(null);
        val2.sort(null);
        return val1.equals(val2);
    }
}