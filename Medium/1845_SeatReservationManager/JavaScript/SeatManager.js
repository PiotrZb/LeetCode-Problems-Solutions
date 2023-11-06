/**
 * @param {number} n
 */
var SeatManager = function(n) {
    this.reservations = []
    for(let i = 0; i < n; i++) {
        this.reservations.push(false)
    }
    this.firsFreeSeatIndex = 0
};

/**
 * @return {number}
 */
SeatManager.prototype.reserve = function() {
    let seat = this.firsFreeSeatIndex + 1
    this.reservations[this.firsFreeSeatIndex] = true

    for(let i = this.firsFreeSeatIndex + 1; i < this.reservations.length; i++) {
        if(!this.reservations[i]) {
            this.firsFreeSeatIndex = i
            break
        }
    }

    if (this.firsFreeSeatIndex + 1 === seat) this.firsFreeSeatIndex = -1

    return seat
};

/** 
 * @param {number} seatNumber
 * @return {void}
 */
SeatManager.prototype.unreserve = function(seatNumber) {
    this.reservations[seatNumber - 1] = false
    if(seatNumber < this.firsFreeSeatIndex + 1 || this.firsFreeSeatIndex === -1) this.firsFreeSeatIndex = seatNumber - 1
};