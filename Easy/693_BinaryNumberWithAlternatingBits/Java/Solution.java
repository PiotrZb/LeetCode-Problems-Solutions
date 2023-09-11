class Solution {
    public boolean hasAlternatingBits(int n) {
        String binaryRepresentation = Integer.toBinaryString(n);
        char currentChar, previousChar = '2';
        for (int i = 0; i < binaryRepresentation.length(); i++){
            currentChar = binaryRepresentation.charAt(i);
            if (currentChar == previousChar) return false;
            else previousChar = currentChar;
        }
        return true;
    }
}