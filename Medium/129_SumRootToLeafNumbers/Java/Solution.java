class Solution {
    public int sumNumbers(TreeNode root) {
        return this.search(root, 0);
    }

    private int search(TreeNode node, int currentNumber) {
        return node == null ? 0 : (node.right == null && node.left == null ? currentNumber * 10 + node.val : this.search(node.left, currentNumber * 10 + node.val) + this.search(node.right, currentNumber * 10 + node.val));
    }
}