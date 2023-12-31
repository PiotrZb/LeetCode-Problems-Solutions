class Solution {
    public char findTheDifference(String s, String t) {
        int sumS = 0, sumT = 0;

        for (int i = 0; i < s.length(); i++) {
            sumS += s.charAt(i);
            sumT += t.charAt(i);
        }

        sumT += t.charAt(t.length() - 1);

        return (char)(sumT - sumS);
    }
}