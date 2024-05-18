from TreeNode import TreeNode
from typing import Optional


class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        self.res = 0

        def dfs(node: Optional[TreeNode]) -> int:
            if not node:
                return 0
            
            balance = node.val + dfs(node.left) + dfs(node.right) - 1
            self.res += abs(balance)

            return balance
        
        dfs(root)

        return self.res