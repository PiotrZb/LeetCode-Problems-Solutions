class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < 13; i++) {
            while (num >= intValues[i]) {
                sb.append(romanSymbols[i]);
                num -= intValues[i];
            }
            
            if (num == 0) break;
        }
        
        return sb.toString();
    }
}