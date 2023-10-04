import TreeNode

class Solution:
    def goodNodes(self, root: TreeNode, max = -10001) -> int:
        return 0 if not root else 1 + self.goodNodes(root.left,root.val) + self.goodNodes(root.right,root.val) if root.val >= max else self.goodNodes(root.left,max) + self.goodNodes(root.right,max)