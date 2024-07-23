import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode dummy = new TreeNode(Integer.MAX_VALUE, root, null), currNode = root, prevNode = dummy;

        while (currNode != null && key != currNode.val) {
            prevNode = currNode;
            if (key > currNode.val) currNode = currNode.right;
            else currNode = currNode.left;
        }

        if (currNode == null) return root;

        if (currNode.val > prevNode.val) prevNode.right = null;
        else prevNode.left = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currNode.left);
        queue.add(currNode.right);

        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (currNode != null) {
                queue.add(currNode.left);
                queue.add(currNode.right);
                this.insertNode(currNode.val, dummy);
            }
        }

        return dummy.left;
    }

    private void insertNode(int val, TreeNode node) {
        if (val < node.val) {
            if (node.left != null) insertNode(val, node.left);
            else node.left = new TreeNode(val);
        }
        else {
            if (node.right != null) insertNode(val, node.right);
            else node.right = new TreeNode(val);
        }
    }
}