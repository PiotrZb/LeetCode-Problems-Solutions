class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0] * (amount + 1) # dp[i] -> number of combinations for amount = i
        dp[0] = 1 # there is exactly one way to make amount = 0

        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = dp[i] + dp[i - coin]

        return dp[-1] # last element stores number of combinations for given amount