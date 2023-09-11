import java.util.HashSet;
import java.util.Hashtable;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Hashtable<Integer, Integer> occurrences = new Hashtable<>();
        for (int num : arr) occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        return occurrences.values().size() == new HashSet<>(occurrences.values()).size();
    }
}