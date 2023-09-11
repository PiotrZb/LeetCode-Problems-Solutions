class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0: return 0
        if n in [1, 2]: return 1
        memo = [0, 1, 1]
        for i in range(3, n + 1):
            s = sum(memo)
            memo[0] = memo[1]
            memo[1] = memo[2]
            memo[2] = s
        return memo[2]