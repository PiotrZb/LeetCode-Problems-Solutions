/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    const l = nums.length;
    let answer = new Array(l);
    let leftPointer = 0;
    let rightPointer = l - 1;
    let leftSquare = nums[leftPointer]**2;
    let rightSquare = nums[rightPointer]**2;

    for (let i = l - 1; i > -1; i--) {
        if (leftSquare > rightSquare) {
            answer[i] = leftSquare;
            leftPointer++;
            leftSquare = nums[leftPointer]**2;
            
        }
        else {
            answer[i] = rightSquare;
            rightPointer--;
            rightSquare = nums[rightPointer]**2;
        }
    }

    return answer;
};