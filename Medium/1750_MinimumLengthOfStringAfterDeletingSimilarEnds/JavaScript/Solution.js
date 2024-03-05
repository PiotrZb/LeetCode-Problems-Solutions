/**
 * @param {string} s
 * @return {number}
 */
var minimumLength = function(s) {
    let leftPointer = 0;
    let rightPointer = s.length - 1;

    while (leftPointer < rightPointer && s[leftPointer] === s[rightPointer]) {
        const char = s[leftPointer];
        while (s[leftPointer] === char) leftPointer++;
        if (leftPointer > rightPointer) return 0;
        while (s[rightPointer] === char) rightPointer--;
    }

    return rightPointer - leftPointer + 1;
};