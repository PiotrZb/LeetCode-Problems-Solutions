/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (strs.length === 0) return "";

    let answer = strs[0];
    
    strs.forEach((s) => {
        while (!s.startsWith(answer)) {
            answer = answer.substring(0,answer.length - 1);
        }
    });

    return answer;
};