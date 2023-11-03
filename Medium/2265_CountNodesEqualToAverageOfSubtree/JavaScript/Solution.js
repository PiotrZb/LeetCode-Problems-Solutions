const TreeNode = require("./TreeNode");

let result

/**
 * @param {TreeNode} root
 * @return {number}
 */
var averageOfSubtree = function(root) {
    result = 0
    search(root)
    return result
};

function search(node) {
    if (node == null) return [0, 0]

    let res1 = search(node.right)
    let res2 = search(node.left)

    let sum = res1[0] + res2[0] + node.val
    let count = res1[1] + res2[1] + 1

    if (Math.floor(sum / count) == node.val) result++

    return [sum, count]
}