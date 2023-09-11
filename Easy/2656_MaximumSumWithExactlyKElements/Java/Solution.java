import java.util.Arrays;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        return Arrays.stream(nums).max().getAsInt() * k + ((k-1) * k / 2);
    }
}