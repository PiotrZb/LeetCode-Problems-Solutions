from TreeNode import TreeNode
from typing import Optional


class Solution(object):
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        parents = {}
        queue = [root]
        startNode = None

        while queue:
            node = queue.pop()

            if node.left:
                parents[node.left.val] = node
                queue.append(node.left)
            
            if node.right:
               parents[node.right.val] = node 
               queue.append(node.right)

            if node.val == startValue:
                startNode = node
                break
        
        queue = [(startNode, None, '')]

        while queue:
            node, prev, path = queue.pop()

            if node.val == destValue:
                return path
            
            if node.left and node.left != prev:
                queue.append((node.left, node, path + 'L'))

            if node.right and node.right != prev:
                queue.append((node.right, node, path + 'R'))

            if node.val in parents and parents[node.val] != prev:
                queue.append((parents[node.val], node, path + 'U'))

        return ''
