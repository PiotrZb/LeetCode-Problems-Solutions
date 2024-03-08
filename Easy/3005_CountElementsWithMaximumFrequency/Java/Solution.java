class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0, count = 0;

        for (int e : nums) {
            freq[e]++;
            if (freq[e] < maxFreq) continue;
            else if (freq[e] == maxFreq) count += freq[e];
            else maxFreq = count = freq[e];
        }

        return count;
    }
}