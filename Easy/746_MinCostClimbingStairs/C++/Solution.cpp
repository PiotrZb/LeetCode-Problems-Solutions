#include <vector>

class Solution {
public:
    int minCostClimbingStairs(std::vector<int>& cost) {
        int l = cost.size();
        int dp[l];
        dp[l - 1] = cost[l - 1];
        dp[l - 2] = cost[l - 2];

        for(int i = l - 3; i >= 0; i--) dp[i] = std::min(dp[i + 1], dp[i + 2]) + cost[i];

        return std::min(dp[0], dp[1]);
    }
};