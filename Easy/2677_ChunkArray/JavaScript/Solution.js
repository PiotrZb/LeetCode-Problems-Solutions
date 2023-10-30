/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */

var chunk = function(arr, size) {
    // let res = []
    // let temp = []

    // arr.forEach(element => {
    //     temp.push(element)

    //     if (temp.length == size) {
    //         res.push(temp)
    //         temp = []
    //     }
    // })

    // if (temp.length > 0) {
    //     res.push(temp)
    // }

    // return res

    let res = []
    for (let i = 0; i < arr.length; i += size) res.push(arr.slice(i, i + size))
    return res
};
