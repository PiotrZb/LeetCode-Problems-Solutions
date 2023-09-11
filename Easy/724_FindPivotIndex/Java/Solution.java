import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int sumRight = Arrays.stream(nums).sum(), sumLeft = 0;
        for (int i = 0; i < nums.length; i++){
            sumRight -= nums[i];
            if (i > 0) sumLeft += nums[i - 1];
            if (sumRight == sumLeft) return i;
        }
        return -1;
    }
}