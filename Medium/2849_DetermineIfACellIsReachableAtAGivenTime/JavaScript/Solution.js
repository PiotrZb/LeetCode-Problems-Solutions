/**
 * @param {number} sx
 * @param {number} sy
 * @param {number} fx
 * @param {number} fy
 * @param {number} t
 * @return {boolean}
 */
var isReachableAtTime = function(sx, sy, fx, fy, t) {
    return !(Math.max(Math.abs(fx - sx), Math.abs(fy - sy)) > t || (t === 1 && sx === fx && sy === fy))
};