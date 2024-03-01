class Solution {
    public String maximumOddBinaryNumber(String s) {
        int number_of_ones = 0;
        for (char c : s.toCharArray()) if (c == '1') number_of_ones++;
        StringBuilder sb = new StringBuilder();

        while (number_of_ones > 1) {
            sb.append('1');
            number_of_ones--;
        }

        while (sb.length() < s.length() - 1) sb.append('0');
        sb.append('1');

        return sb.toString();
    }
}