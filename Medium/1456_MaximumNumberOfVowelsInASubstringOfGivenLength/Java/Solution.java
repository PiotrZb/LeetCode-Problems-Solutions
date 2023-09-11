import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxNumberOfVowels = 0, currentNumberOfVowels = 0;
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (vowels.contains(sArr[i])) currentNumberOfVowels++;
            if (i >= k && vowels.contains(sArr[i - k])) currentNumberOfVowels--;
            if (currentNumberOfVowels == k) return k;
            maxNumberOfVowels = Integer.max(maxNumberOfVowels, currentNumberOfVowels);
        }
        return maxNumberOfVowels;
    }
}