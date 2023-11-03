/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function(target, n) {
    let answer = []
    let pointer = 0

    for (let streamNumber = 1; streamNumber <= n; streamNumber++) {
        answer.push("Push")
        if (streamNumber !== target[pointer]) answer.push("Pop")
        else pointer++
        if (pointer === target.length) break
    }

    return answer
};