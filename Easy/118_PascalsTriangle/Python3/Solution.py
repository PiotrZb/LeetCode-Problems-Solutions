class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        answer = [[1]]

        for i in range(1, numRows):
            row = [1]

            for j in range(1, i):
                row.append(answer[-1][j] + answer[-1][j - 1])

            row.append(1)
            answer.append(row)

        return answer