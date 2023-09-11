import TreeNode

class Solution:
    def findSecondMinimumValue(self, root: Optional[TreeNode]) -> int:
        if (not root.right): return -1
        elif (root.left.val != root.val):
            rightBranchMinVal = self.findSecondMinimumValue(root.right)
            return min(rightBranchMinVal, root.left.val) if rightBranchMinVal > 0 else root.left.val
        elif (root.right.val != root.val):
            leftBranchMinVal = self.findSecondMinimumValue(root.left)
            return min(leftBranchMinVal, root.right.val) if leftBranchMinVal > 0 else root.right.val
        else: 
            rightBranchMinVal = self.findSecondMinimumValue(root.right)
            leftBranchMinVal = self.findSecondMinimumValue(root.left)
            if rightBranchMinVal == -1 and leftBranchMinVal == -1: return -1
            elif rightBranchMinVal == -1: return leftBranchMinVal
            else: return rightBranchMinVal