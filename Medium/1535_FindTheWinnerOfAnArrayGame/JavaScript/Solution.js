/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var getWinner = function(arr, k) {
    const maxNumber = Math.max(...arr)
    if(arr.length <= k) return maxNumber

    let currentNumber = arr[0]
    let winsCount = 0

    for(let i = 1; i < arr.length; i++) {
        if(arr[i] === maxNumber) return maxNumber    

        if(currentNumber > arr[i]) winsCount++
        else {
            currentNumber = arr[i]
            winsCount = 1
        }

        if (winsCount === k) return currentNumber
    }
};