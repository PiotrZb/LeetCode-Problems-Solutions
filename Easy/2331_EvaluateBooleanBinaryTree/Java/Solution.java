class Solution {
    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return this.evaluateTree(root.left) || this.evaluateTree(root.right);
        }
        return this.evaluateTree(root.left) && this.evaluateTree(root.right);
    }
}