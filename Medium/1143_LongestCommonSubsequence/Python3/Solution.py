class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        w = len(text1) + 1
        h = len(text2) + 1
        dp = [[0] * w for x in range(h)]

        for i in range(1, h):
            for j in range(1, w):
                if text1[j - 1] == text2[i - 1]: dp[i][j] = dp[i - 1][j - 1] + 1
                else: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]) 
        
        return dp[h - 1][w - 1]