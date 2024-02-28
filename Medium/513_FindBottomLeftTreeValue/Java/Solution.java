import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int bottomLeftValue = -1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            bottomLeftValue = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }

        // int currentLayer = 0;

        // class Pair {
        //     public TreeNode node;
        //     public int layer;

        //     public Pair(TreeNode node, int layer) {
        //         this.node = node;
        //         this.layer = layer;
        //     }
        // }

        // Queue<Pair> queue = new LinkedList<Pair>(); 
        // queue.add(new Pair(root, 1));

        // while (!queue.isEmpty()) {
        //     Pair currentPair = queue.poll();
        //     if (currentPair.node == null) continue;
        //     if (currentPair.layer > currentLayer) {
        //         bottomLeftValue = currentPair.node.val;
        //         currentLayer = currentPair.layer;
        //     }
        //     queue.add(new Pair(currentPair.node.left, currentPair.layer + 1));
        //     queue.add(new Pair(currentPair.node.right, currentPair.layer + 1));
        // }

        return bottomLeftValue;
    }
}