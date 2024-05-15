import heapq

class Solution:
    def maximumSafenessFactor(self, grid: list[list[int]]) -> int:
        n = len(grid)

        for r in range(n):
            for c in range(n):
                top = 2137 if not r else grid[r - 1][c]
                left = 2137 if not c else grid[r][c - 1]
                grid[r][c] = 0 if grid[r][c] else min(top, left) + 1
        
        for r in range(n - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                bottom = 2137 if r == n - 1 else grid[r + 1][c]
                right = 2137 if c == n - 1 else grid[r][c + 1]
                grid[r][c] = min(grid[r][c], bottom + 1, right + 1)

        heap = []
        heapq.heappush(heap, [-grid[0][0], 0, 0])

        while heap:
            s, r, c = heapq.heappop(heap)

            if grid[r][c] < 0:
                continue

            if r == c == n - 1:
                return -s

            grid[r][c] = -1

            if c + 1 < n:
                heapq.heappush(heap, [max(s, -grid[r][c + 1]), r, c + 1])
            if c > 0:
                heapq.heappush(heap, [max(s, -grid[r][c - 1]), r, c - 1])
            if r + 1 < n:
                heapq.heappush(heap, [max(s, -grid[r + 1][c]), r + 1, c])
            if r > 0:
                heapq.heappush(heap, [max(s, -grid[r - 1][c]), r - 1, c])

        return 0