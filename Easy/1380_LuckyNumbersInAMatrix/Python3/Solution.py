class Solution:
    def luckyNumbers (self, matrix: list[list[int]]) -> list[int]:
        return list({min(row) for row in matrix} & {max(col) for col in zip(*matrix)})
    
        # res = []

        # for c in range(len(matrix[0])):
        #     maxVal, maxValRow = 0, None

        #     for row in matrix:
        #         if row[c] > maxVal:
        #             maxVal, maxValRow = row[c], row
            
        #     if min(maxValRow) == maxVal:
        #         res.append(maxVal)
            
        # return res