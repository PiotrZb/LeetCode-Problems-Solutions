import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = map.getOrDefault(nums[right], 0);

            if (count == k) {
                while (nums[left] != nums[right]) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    left++;
                }
                left++;
            }
            else map.put(nums[right], count + 1);
            
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}