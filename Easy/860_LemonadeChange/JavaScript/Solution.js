/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
  let fives = 0, tens = 0;

  for (let bill of bills) {
    if (bill === 5) fives++;
    else if (bill === 10) {
      if (fives < 1) return false;
      fives--;
      tens++;
    }
    else {
      if (tens > 0 && fives > 0) {
        fives--;
        tens--;
      }
      else if (fives > 2) fives -= 3;
      else return false;
    }
  }

  return true;
};