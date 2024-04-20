class Solution:
    def findFarmland(self, land: list[list[int]]) -> list[list[int]]:
        numberOfRows = len(land)
        numberOfCols = len(land[0])
        answer = []

        for r1 in range(numberOfRows):
            for c1 in range(numberOfCols):
                if land[r1][c1]:
                    r2 = r1
                    c2 = c1

                    while r2 < numberOfRows - 1 and land[r2 + 1][c1]:
                        r2 += 1

                    while c2 < numberOfCols - 1 and land[r1][c2 + 1]:
                        c2 += 1

                    answer.append([r1, c1, r2, c2])

                    for r in range(r1, r2 + 1):
                        for c in range(c1, c2 + 1):
                            land[r][c] = 0

        return answer

