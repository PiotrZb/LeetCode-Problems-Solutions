class Solution:
    def getMaximumGold(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        res = 0

        def search(r, c):
            if r < 0 or r >= m or c < 0 or c >= n or not grid[r][c]:
                return 0
            
            temp = grid[r][c]
            grid[r][c] = 0
            res = temp + max(search(r + 1, c), search(r - 1, c), search(r, c + 1), search(r, c - 1))
            grid[r][c] = temp

            return res

        for r in range(m):
            for c in range(n):
                res = max(res, search(r, c))

        return res