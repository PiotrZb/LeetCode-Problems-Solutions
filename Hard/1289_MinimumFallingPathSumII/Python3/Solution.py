class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        for rowId in range(len(grid) - 2, -1, -1):
            for colId in range(len(grid)):
                grid[rowId][colId] += min([x for i, x in enumerate(grid[rowId + 1]) if i != colId])

        return min(grid[0])