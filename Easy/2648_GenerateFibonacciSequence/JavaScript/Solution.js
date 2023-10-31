/**
 * @return {Generator<number>}
 */
 
var fibGenerator = function*() {
    let xn_2 = 0;
    let xn_1 = 1;
    
    while (true) {
        yield xn_2;
        [xn_2, xn_1] = [xn_1, xn_1 + xn_2];
    }

    // let x_n1
    // let x_n2
    // let x_n

    // yield x_n2 = 0
    // yield x_n1 = 1

    // while (true) {
    //     yield x_n = x_n1 + x_n2
    //     x_n2 = x_n1
    //     x_n1 = x_n
    // }  
};