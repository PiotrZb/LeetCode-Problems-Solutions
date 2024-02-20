/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    const n = nums.length;
    let s = n * (n + 1) / 2;
    for (let i = 0; i < n; i++) {
        s -= nums[i];
    }
    return s;
};