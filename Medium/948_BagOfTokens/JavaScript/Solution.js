/**
 * @param {number[]} tokens
 * @param {number} power
 * @return {number}
 */
var bagOfTokensScore = function(tokens, power) {
    tokens.sort((a, b) => a - b)

    let leftPointer = 0;
    let rightPointer = tokens.length - 1;
    let maxScore = 0;
    let score = 0;

    while (leftPointer <= rightPointer) {
        if (tokens[leftPointer] <= power) {
            score++;
            power -= tokens[leftPointer];
            leftPointer++;
        }
        else if (score > 0) {
            score--;
            power += tokens[rightPointer];
            rightPointer--;
        }
        else break;

        maxScore = Math.max(maxScore, score);
    }

    return maxScore;
};