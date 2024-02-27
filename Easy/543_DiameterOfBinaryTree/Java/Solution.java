
class Solution {
    private int d;

    public Solution(){
        this.d = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        this.search(root);
        return this.d;
    }

    public int search(TreeNode node) {
        if (node == null) return 0;
        int leftBranchLen = this.search(node.left);
        int rightBranchLen = this.search(node.right);
        this.d = Math.max(this.d, leftBranchLen + rightBranchLen);
        return 1 + Math.max(leftBranchLen, rightBranchLen);
    }
}