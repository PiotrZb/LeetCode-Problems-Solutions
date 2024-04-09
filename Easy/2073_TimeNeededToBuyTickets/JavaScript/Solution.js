/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
    let time = 0;

    for (let i = 0; i < tickets.length; i++) {
        if (tickets[i] < tickets[k]) time += tickets[i];
        else if (i > k) time += tickets[k] - 1;
        else time += tickets[k];
    }

    return time;
};