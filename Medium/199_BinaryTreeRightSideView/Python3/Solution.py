import TreeNode

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        queue = [(root, 1)]
        nodesOnTheRight = []

        while queue:
            currentNode, currentLayer = queue.pop()
            if len(nodesOnTheRight) < currentLayer: nodesOnTheRight.append(currentNode.val)
            if currentNode.right: queue.insert(0, (currentNode.right, currentLayer + 1))
            if currentNode.left: queue.insert(0, (currentNode.left, currentLayer + 1))

        return nodesOnTheRight