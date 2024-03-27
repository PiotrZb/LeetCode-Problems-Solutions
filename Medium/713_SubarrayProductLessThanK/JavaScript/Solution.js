/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numSubarrayProductLessThanK = function(nums, k) {
    if (k < 1) return 0;

    let left = 0, answer = 0, currProduct = 1;

    for (let right = 0; right < nums.length; right++) {
        currProduct *= nums[right];

        while (currProduct >= k && left < right) {
            currProduct /= nums[left];
            left++;
        }

        if (currProduct < k) answer += right - left + 1;
    }

    return answer;
};