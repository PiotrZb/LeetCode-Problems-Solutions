class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val, root, null);
            return newRoot;
        }
        this.dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int depth, int currDepth) {
        if (node == null) return;
        if (depth - 1 == currDepth) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
            return;
        }
        this.dfs(node.left, val, depth, currDepth + 1);
        this.dfs(node.right, val, depth, currDepth + 1);
    }
}