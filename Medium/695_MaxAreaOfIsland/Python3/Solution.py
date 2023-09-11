class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        maxArea = 0
        for m in range(len(grid)):
            for n in range(len(grid[0])):
                if grid[m][n]: maxArea = max(maxArea, self.getArea(m, n, grid))
        return maxArea

    def getArea(self, m: int, n: int, grid: List[List[int]]) -> int:
        if 0 <= m < len(grid) and 0 <= n < len(grid[0]) and grid[m][n]:
            grid[m][n] = 0
            return 1 + self.getArea(m + 1, n, grid) + self.getArea(m, n + 1, grid) + \
                        self.getArea(m - 1, n, grid) + self.getArea(m, n - 1, grid)
        else: return 0