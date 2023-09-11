class Solution {
    public int maxDepth(TreeNode root) { return this.search(root, 0); }

    private int search(TreeNode currentNode, int currentDepth){ return currentNode == null ? currentDepth : Math.max(search(currentNode.left, currentDepth + 1), search(currentNode.right, currentDepth + 1)); }
}