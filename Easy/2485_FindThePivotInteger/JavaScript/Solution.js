/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function(n) {
    let rSum = n * (n + 1) / 2;
    let lSum = 0;

    for (let i = 1; i <= n; i++) {
        lSum += i;
        rSum -= (i - 1);
        if (lSum === rSum) return i;
    }

    return -1;
};