/**
 * @param {number} millis
 * @return {Promise}
 */

async function sleep(millis) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(0)
        }, millis)
    })
}