class Solution {
    private int sum;

    public Solution() { this.sum = 0; }

    public TreeNode bstToGst(TreeNode root) {
        this.dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        this.dfs(node.right);
        this.sum += node.val;
        node.val = sum;
        this.dfs(node.left);
    }
}