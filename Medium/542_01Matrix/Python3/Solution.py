from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        visited = deque()
        h, w = len(mat), len(mat[0])

        for row in range(h):
            for col in range(w):
                if mat[row][col] == 0: visited.append((row , col))
                else: mat[row][col] = -1

        while visited:
            row, col = visited.popleft()

            for dy, dx in dirs:
                newRow, newCol = row + dy, col + dx
                if 0 <= newRow < h and 0 <= newCol < w and mat[newRow][newCol] < 0:
                    mat[newRow][newCol] = mat[row][col] + 1
                    visited.append((newRow, newCol))

        return mat