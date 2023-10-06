class Solution:
    def integerBreak(self, n: int) -> int:
        if n == 2: return 1
        if n == 3: return 2

        product = 1

        while n:
            if n > 4 or n == 3:
                n -= 3
                product *= 3
            else:
                n -= 2
                product *= 2

        return product