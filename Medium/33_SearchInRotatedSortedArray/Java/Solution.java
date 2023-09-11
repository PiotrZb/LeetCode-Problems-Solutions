class Solution {
    public int search(int[] nums, int target) {
        int pivot = 0;
        
        if (nums[0] > nums[nums.length - 1]) { // array was rotated
            pivot = this.findPivot(nums);
        }

        int ansSubArr1 = this.binarySearch(nums, target, 0, pivot - 1);
        int ansSubArr2 = this.binarySearch(nums, target, pivot, nums.length - 1);

        return ansSubArr1 > ansSubArr2 ? ansSubArr1 : ansSubArr2;
    }

    private int findPivot(int[] nums) {
        int m, l = 0, r = nums.length - 1;
        while (l <= r) {
            m = (r + l) / 2;
            if (nums[m] > nums[nums.length - 1]) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

    private int binarySearch(int[] nums, int target, int startIndex, int endIndex) {
        int m;
        while (startIndex <= endIndex) {
            m = (startIndex + endIndex) / 2;
            if (nums[m] == target) return m;
            if (nums[m] > target) endIndex = m - 1;
            else startIndex = m + 1;
        }
        return -1;
    }
}