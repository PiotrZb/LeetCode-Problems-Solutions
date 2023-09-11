class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        perimiter = 0
        for row in range(0, len(grid)):
            for col in range(0, len(grid[0])):
                if grid[row][col] == 1:
                    if row - 1 < 0 or grid[row - 1][col] == 0: perimiter += 1
                    if row + 1 >= len(grid) or grid[row + 1][col] == 0: perimiter += 1
                    if col - 1 < 0 or grid[row][col - 1] == 0: perimiter += 1
                    if col + 1 >= len(grid[0]) or grid[row][col + 1] == 0: perimiter += 1
        return perimiter