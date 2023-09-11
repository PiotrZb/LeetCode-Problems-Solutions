#include <vector>

class Solution {
public:
    int uniquePathsWithObstacles(std::vector<std::vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) obstacleGrid[i][j] = 1;
                else if (obstacleGrid[i][j] == 0) {
                    if (i - 1 >= 0) obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                    if (j - 1 >= 0) obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                } else obstacleGrid[i][j] = 0;
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
};