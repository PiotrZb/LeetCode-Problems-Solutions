import java.util.Arrays;

class Solution {
    public int maxProductDifference(int[] nums) {
        int a = Integer.MIN_VALUE, b = 0, c = Integer.MAX_VALUE, d = 0;

        for (int num : nums) {
            if (num >= a) {
                b = a;
                a = num;
            }
            else if (num > b) b = num;
            else if (num <= c) {
                d = c;
                c = num;
            }
            else if (num < d) d = num;
        }

        return (a * b) - (c * d);

        // Arrays.sort(nums);
        // return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}