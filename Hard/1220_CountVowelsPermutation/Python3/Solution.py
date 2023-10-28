class Solution:
    def countVowelPermutation(self, n: int) -> int:
        divider = 1000000007
        dp = [[1] * 5] * 2 # columns: 'a', 'e', 'i', 'o', 'u'

        for _ in range(1, n):
            dp[0] = dp[1].copy()
            for col in range(5):
                if col == 0:
                    dp[1][col] = dp[0][1] + dp[0][2] + dp[0][4]
                elif col == 1:
                    dp[1][col] = dp[0][0] + dp[0][2]
                elif col == 2:
                    dp[1][col] = dp[0][1] + dp[0][3]
                elif col == 3:
                    dp[1][col] = dp[0][2]
                else:
                    dp[1][col] = dp[0][2] + dp[0][3]
            
        return sum(dp[1]) % divider