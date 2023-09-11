class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp, dp_1 = 0, dp_2 = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            dp = Math.min(dp_2 + cost[i - 2], dp_1 + cost[i - 1]);
            dp_2 = dp_1;
            dp_1 = dp;
        }

        return dp_1;
    }
}