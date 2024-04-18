#include <vector>

class Solution {
public:
    int islandPerimeter(std::vector<std::vector<int>>& grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j]) {
                    if (i == 0 || !grid[i - 1][j]) perimeter++;
                    if (i == grid.size() - 1 || !grid[i + 1][j]) perimeter++;
                    if (j == 0 || !grid[i][j - 1]) perimeter++;
                    if (j == grid[0].size() - 1 || !grid[i][j + 1]) perimeter++;
                }
            }
        }

        return perimeter;
    }
};