/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
    let balance = new Array(n + 1).fill(0)

    trust.forEach(e => {
        balance[e[0]]--;
        balance[e[1]]++;
    });

    for (let i = 1; i <= n; i++) if (balance[i] === n - 1) return i;

    // let balance = {[n]:0};

    // for (let [a, b] of trust) {
    //     balance[a] = (balance[a] || 0) - 1;
    //     balance[b] = (balance[b] || 0) + 1;
    // }

    // for (let i = 1; i <= n; i++) if (balance[i] === n - 1) return i;

    return -1;
};