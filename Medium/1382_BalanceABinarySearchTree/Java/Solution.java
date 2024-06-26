import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> inOrderValues;

    public Solution() { this.inOrderValues = new ArrayList<>(); }

    public TreeNode balanceBST(TreeNode root) {
        this.inOrderTraversal(root);
        return this.buildBalancedBST(0, this.inOrderValues.size() - 1);
    }

    private TreeNode buildBalancedBST(int start, int end) {
        int mid = start + (end - start) / 2;
        return end < start ? null : new TreeNode(this.inOrderValues.get(mid), 
                                                 this.buildBalancedBST(start, mid - 1), 
                                                 this.buildBalancedBST(mid + 1, end));
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            this.inOrderTraversal(node.left);
            this.inOrderValues.add(node.val);
            this.inOrderTraversal(node.right);
        }
    }
}