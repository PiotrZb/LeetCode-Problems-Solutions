from TreeNode import TreeNode

class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        self.distance = distance
        self.res = 0
        self.dfs(root)
        return self.res
    
    def dfs(self, node: TreeNode) -> list[int]:
        if not node.left and not node.right:
            return [1]
        
        leftLeafs = self.dfs(node.left) if node.left else []
        rightLeafs = self.dfs(node.right) if node.right else []

        for x in leftLeafs:
            for y in rightLeafs:
                self.res += x + y <= self.distance
        
        return [x + 1 for x in leftLeafs + rightLeafs if x < self.distance]