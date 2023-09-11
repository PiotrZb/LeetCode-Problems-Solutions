class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int distance = k;
        for (int number : nums){
            if (number == 0) distance++;
            else if (distance < k) return false;
            else distance = 0;
        }
        return true;
    }
}