class Solution {
    public int countSegments(String s) {
        if (s.isEmpty()) return 0;
        int x = s.split("\\s+").length;
        if (s.charAt(0) == ' ' && x > 0) return x - 1;
        return x;
    }
}