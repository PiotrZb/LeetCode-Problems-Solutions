from TreeNode import TreeNode
from typing import Optional
import string


class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode], s = "") -> str:
        return "{" if not root else \
                string.ascii_lowercase[root.val] + s if not (root.left or root.right) else \
                min(self.smallestFromLeaf(root.left, string.ascii_lowercase[root.val] + s), \
                    self.smallestFromLeaf(root.right, string.ascii_lowercase[root.val] + s))