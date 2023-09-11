import java.util.HashMap;
import java.util.Map;

class Solution{
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Integer> charToSetId = new HashMap<>();
        char[] minChars = new char[s1.length()];

        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            Integer set1 = charToSetId.get(c1);
            Integer set2 = charToSetId.get(c2);

            if (set1 == null && set2 == null) {
                charToSetId.put(c1, i);
                charToSetId.put(c2, i);
                minChars[i] = c1 < c2 ? c1 : c2;
            } else if (set1 == null && set2 != null) {
                charToSetId.put(c1, set2.intValue());
                if (c1 < minChars[set2.intValue()]) minChars[set2.intValue()] = c1;
            } else if (set1 != null && set2 == null) {
                charToSetId.put(c2, set1.intValue());
                if (c2 < minChars[set1.intValue()]) minChars[set1.intValue()] = c2;
            } else if (set1.intValue() != set2.intValue()){
                for (Character key : charToSetId.keySet()){
                    if (charToSetId.get(key) == set2.intValue()){
                        charToSetId.put(key, set1.intValue());
                        if (key.charValue() < minChars[set1.intValue()]) minChars[set1.intValue()] = key;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : baseStr.toCharArray()) {
            Integer s = charToSetId.get(c);
            sb.append(s == null ? c : minChars[s]);
        }

        return sb.toString();
    }
}