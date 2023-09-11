#include <vector>

class Solution {
public:
    int uniquePaths(int m, int n) {
        std::vector<std::vector<int>> dp(m + 1, std::vector<int>(n + 1, 0));
        for (int i = 1; i <= m; i++) for (int j = 1; j <= n; j++) dp[i][j] = i == 1 && j == 1 ? 1 : dp[i - 1][j] + dp[i][j - 1];
        return dp[m][n];
    }
};