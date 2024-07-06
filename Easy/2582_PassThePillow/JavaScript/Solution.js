/**
 * @param {number} n
 * @param {number} t
 * @return {number}
 */
var passThePillow = (n, t) => ~~(t / (n - 1)) & 1 ? n - t % (n - 1) : t % (n - 1) + 1;