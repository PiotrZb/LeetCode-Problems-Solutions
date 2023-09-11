#include <vector>

class Solution {
public:
    std::vector<int> countBits(int n) {
        std::vector<int> answer(n + 1, 0);
        for (int i = 0; i <= n; i++) answer[i] = answer[i >> 1] + (i & 1);
        return answer;
    }
};