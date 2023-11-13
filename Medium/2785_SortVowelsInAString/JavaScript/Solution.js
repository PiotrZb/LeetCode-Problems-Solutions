/**
 * @param {string} s
 * @return {string}
 */
var sortVowels = function(s) {
    // const vowels = 'aeiouAEIOU';
    // const sortedVowels = [...s].filter(char => vowels.includes(char)).sort();
    // return [...s].map(char => vowels.includes(char) ? sortedVowels.shift() : char).join('');

    const vowels = ['a','A','e','E','i','I','o','O','u','U']
    let vowelsInString = []

    for (let char of s) if (vowels.includes(char)) vowelsInString.push(char)

    vowelsInString.sort()
    let answer = ""
    let vowelIndex = 0

    for(let char of s) answer += vowels.includes(char) ? vowelsInString[vowelIndex++] : char

    return answer
};