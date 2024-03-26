/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    // get rid of negative numbers and zeros
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] <= 0) nums[i] = nums.length + 1;
    }  

    // use sign as a boolean variable
    for (let i = 0; i < nums.length; i++) {
        if (Math.abs(nums[i]) <= nums.length) nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
    }

    // find first index which is not used
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] > 0) return i + 1;
    }

    // if all indexes have been used
    return nums.length + 1;
};