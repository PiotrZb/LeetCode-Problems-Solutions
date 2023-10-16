#include <vector>

class Solution {
public:
    std::vector<int> getRow(int rowIndex) {
        if (rowIndex == 0 || rowIndex == 1) return std::vector<int>(rowIndex + 1,1);

        std::vector<int> answer(rowIndex + 1, 1);
        for (int row = 2; row <= rowIndex; row++) {
            for (int i = row - 1; i > 0; i--) {
                answer[i] += answer[i - 1];
            }
        }

        return answer;
    }
};