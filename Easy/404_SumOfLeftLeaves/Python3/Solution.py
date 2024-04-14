from typing import Optional
from TreeNode import TreeNode

class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:

        def search(node: TreeNode, left: bool) -> int:
            if not node:
                return 0

            if not node.right and not node.left and left:
                return node.val
            
            return search(node.left, True) + search(node.right, False)

        return search(root, False)