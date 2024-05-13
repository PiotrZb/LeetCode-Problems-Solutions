class Solution:
    def matrixScore(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ones_in_cols = [0] * n

        for row in grid:
            for col in range(n - 1, -1, -1):
                if row[0]:
                    row[col] = 0 if row[col] else 1
                ones_in_cols[col] += row[col]
        
        return sum([max(ones_in_cols[col], m - ones_in_cols[col]) * 2**(n - 1 - col) for col in range(n)])