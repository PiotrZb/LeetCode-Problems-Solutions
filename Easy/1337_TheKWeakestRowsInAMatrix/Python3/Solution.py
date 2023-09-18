class Solution:
    def kWeakestRows(self, mat: list[list[int]], k: int) -> list[int]:
        return [x[1] for x in sorted([(sum(row), rowId) for rowId, row in enumerate(mat)])[:k]]