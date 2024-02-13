class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int leftPointer = 0, rightPointer = word.length() - 1;
            boolean isPalindromic = true;

            while (leftPointer < rightPointer) {
                if (word.charAt(leftPointer) != word.charAt(rightPointer)) {
                    isPalindromic = false;
                    break;
                } 
                
                leftPointer++;
                rightPointer--;
            }

            if (isPalindromic) return word;
        }

        return "";
    }
}