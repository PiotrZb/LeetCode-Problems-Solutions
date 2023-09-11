import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public ArrayList<TreeNode> generateTrees(int n) { return this.search(1, n, new HashMap<>()); }

    private ArrayList<TreeNode> search(int startVal, int endVal, Map<ArrayList<Integer>, ArrayList<TreeNode>> memo) {
        ArrayList<Integer> key = new ArrayList<>(Arrays.asList(startVal, endVal));
        if (memo.containsKey(key)) return memo.get(key);

        ArrayList<TreeNode> answer = new ArrayList<>();
        if (startVal > endVal) answer.add(null);
        else {
            for (int i = startVal; i <= endVal; i++) {
                ArrayList<TreeNode> leftSubBTS = this.search(startVal, i - 1, memo);
                ArrayList<TreeNode> rightSubBTS = this.search(i + 1, endVal , memo);
                for (TreeNode leftChild : leftSubBTS){
                    for (TreeNode rightChild : rightSubBTS){
                        TreeNode node = new TreeNode(i, leftChild, rightChild);
                        answer.add(node);
                    }
                }
            }   
        }

        memo.put(key, answer);
        return answer;
    }
}