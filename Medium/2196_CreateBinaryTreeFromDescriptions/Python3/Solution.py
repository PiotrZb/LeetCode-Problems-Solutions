from TreeNode import TreeNode

class Solution(object):
    def createBinaryTree(self, descriptions):
        """
        :type descriptions: List[List[int]]
        :rtype: Optional[TreeNode]
        """
        
        graph = {}
        childs = set()

        for parent, child, isLeft in descriptions:
            if parent not in graph:
                graph[parent] = TreeNode(parent)
            
            if child not in graph:
                graph[child] = TreeNode(child)

            if isLeft:
                graph[parent].left = graph[child]
            else:
                graph[parent].right = graph[child]

            childs.add(child)

        for node in graph:
            if node not in childs:
                return graph[node]
            
        return None