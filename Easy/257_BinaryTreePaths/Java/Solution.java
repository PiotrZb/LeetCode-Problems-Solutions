import java.util.ArrayList;
import java.util.List;
 
class Solution {
    private List<String> paths;
    private ArrayList<TreeNode> path;

    public Solution(){
        this.paths = new ArrayList<>();
        this.path = new ArrayList<>();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        this.search(root);
        return this.paths;
    }

    private boolean isLeaf(TreeNode node){ return node.left == null && node.right == null; }

    private void search(TreeNode node){
        this.path.add(node);

        if (this.isLeaf(node)){
            this.paths.add(this.printPath());
        }else{
            if (node.left != null){ this.search(node.left); }
            if (node.right != null){ this.search(node.right); }
        }

        this.path.remove(path.size() - 1);
    }

    private String printPath(){
        StringBuilder answer = new StringBuilder();
        answer.append(this.path.get(0).val);
        for (int i = 1; i < this.path.size(); i++){
            answer.append("->");
            answer.append(this.path.get(i).val);
        }
        return answer.toString();
    }
}