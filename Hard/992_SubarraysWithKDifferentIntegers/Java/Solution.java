class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int answer = 0, left = 0, mid = 0;

        for (int right = 0; right < nums.length; right++) {
            count[nums[right]]++;

            if (count[nums[right]] == 1) k--;

            if (k < 0) {
                while (k < 0) {
                    count[nums[mid]]--;
                    if (count[nums[mid]] == 0) k++;
                    mid++;
                }

                left = mid;
            }

            while (count[nums[mid]] > 1) {
                count[nums[mid]]--;
                mid++;
            }
            
            if (k == 0) answer += mid - left + 1;
        }

        return answer;
    }
}