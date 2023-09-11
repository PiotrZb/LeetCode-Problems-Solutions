class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] sortedArray = new int[nums.length];
        int oddIndex = 1, evenIndex = 0;
        for (int number : nums){
            if (number % 2 == 0){
                sortedArray[evenIndex] = number;
                evenIndex += 2;
            }
            else{
                sortedArray[oddIndex] = number;
                oddIndex += 2;
            }
        }
        return sortedArray;
    }
}