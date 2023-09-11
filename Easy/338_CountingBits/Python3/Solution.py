class Solution:
    def countBits(self, n: int) -> List[int]:
        answer = [0]
        for i in range(1, n + 1): 
            result, rest = divmod(i, 2)
            answer.append(rest + answer[result])
        return answer