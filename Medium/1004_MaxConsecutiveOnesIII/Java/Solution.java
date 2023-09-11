import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int leftPointer = 0, rightPointer, maxLen = 0;
        Queue<Integer> encounteredZeros = new LinkedList<>();

        for (rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            if (nums[rightPointer] == 0) {
                if (encounteredZeros.size() < k) {
                    encounteredZeros.add(rightPointer);
                } else {
                    encounteredZeros.add(rightPointer);
                    maxLen = Integer.max(maxLen, rightPointer  - leftPointer);
                    leftPointer = encounteredZeros.poll() + 1;
                }
            }
        }
        maxLen = Integer.max(maxLen, rightPointer - leftPointer);

        return maxLen;
    }
}