import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int rightPointer = nums.length - 1, leftPointer = 0, answer = -1;
        while (leftPointer < rightPointer) answer = Math.max(answer, nums[leftPointer++] + nums[rightPointer--]);
        return answer;
    }
}