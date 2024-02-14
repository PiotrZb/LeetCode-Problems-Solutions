class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positivePointer = 0, negativePointer = 1, index = 0, len = nums.length;
        int [] newArr = new int[len];

        while (positivePointer < len || negativePointer < len) {
            if (nums[index] > 0) {
                newArr[positivePointer] = nums[index];
                positivePointer += 2;
            }
            else if (nums[index] < 0) {
                newArr[negativePointer] = nums[index];
                negativePointer += 2;
            }

            index++;
        }

        return newArr;
    }
}