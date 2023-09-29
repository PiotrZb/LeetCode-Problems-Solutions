class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 2) return true;

        // monotone increasing -> 1, monotone decreasing -> -1
        int currentMonotonicity = 0;

        for(int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];

            if (currentMonotonicity == 0 && diff != 0) currentMonotonicity = diff > 0 ? 1 : -1;
            else if (currentMonotonicity != 0 && ((currentMonotonicity == -1 && diff > 0 ) || (currentMonotonicity == 1 && diff < 0))) return false; 
        }

        return true;
    }
}