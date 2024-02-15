/**
 * @param {number[]} nums
 * @return {number}
 */
var largestPerimeter = function(nums) {
    nums.sort((a, b) => {
        return b - a;
    })

    let sum = 0;
    nums.forEach((num) => {
        sum += num;
    })

    for (let k = 0; k < nums.length - 2; k++) {
        if ((sum - nums[k]) > nums[k]) return sum;
        sum -= nums[k];
    }

    return -1;
};