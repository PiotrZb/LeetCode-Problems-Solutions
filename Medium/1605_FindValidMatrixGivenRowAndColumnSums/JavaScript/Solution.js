/**
 * @param {number[]} rowSum
 * @param {number[]} colSum
 * @return {number[][]}
 */
var restoreMatrix = function(rowSum, colSum) {
    const res = Array(rowSum.length).fill(0).map(() => Array(colSum.length));

    for (let r = 0; r < rowSum.length; r++) {
        for (let c = 0; c < colSum.length; c++) {
            res[r][c] = Math.min(rowSum[r], colSum[c]);
            colSum[c] -= res[r][c];
            rowSum[r] -= res[r][c];
        }
    }

    return res;
};