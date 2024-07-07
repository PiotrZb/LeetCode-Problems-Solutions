/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = (bottles, exchange) => {
    let res = 0;

    for (let empty = 0; bottles; empty %= exchange) {
        res += bottles;
        empty += bottles;
        bottles = ~~(empty / exchange);
    }

    return res;
};