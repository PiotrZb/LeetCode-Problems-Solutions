class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        // looping forward
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) answer[i] = answer[i - 1] * nums[i - 1];

        // looping backwards
        int x = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            answer[i] *= x;
            x *= nums[i];
        }

        return answer;
    }
}