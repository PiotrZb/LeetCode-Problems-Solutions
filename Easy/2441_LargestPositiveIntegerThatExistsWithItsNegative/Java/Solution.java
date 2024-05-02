import java.util.Arrays;

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] > -1) break;
            if (nums[left] == -nums[right]) return nums[right];
            if (nums[left] < -nums[right]) left++;
            else right--;
        }
        return -1;
    }
}