import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int currLvl = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int parity = currLvl % 2;
            int previousVal = (parity == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.val % 2 == parity) return false;
                if (parity == 1 && previousVal <= currNode.val) return false;
                if (parity == 0 && previousVal >= currNode.val) return false;

                previousVal = currNode.val;

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }

            currLvl++;
        }

        return true;
    }
}