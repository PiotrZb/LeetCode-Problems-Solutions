class Solution {
    public int minDeletions(String s) {
        // Counting letters
        int[] lettersCount = new int[26]; // 26 -> number of lowercase English letters
        for (char letter : s.toCharArray()) lettersCount[letter - 'a']++; // letter - 'a' -> allows to get indexes from 0 to 25

        // Finding minimum number of deletions
        int numberOfDeletions = 0;
        boolean[] usedFrequencies = new boolean[s.length() + 1];
        for (int frequency : lettersCount) {
            while (usedFrequencies[frequency]) { // if frequency is already in use decrement current frequency (delete one letter)
                frequency--;
                numberOfDeletions++;
            }
            if (frequency > 0) usedFrequencies[frequency] = true;
        }

        return numberOfDeletions;
    }
}