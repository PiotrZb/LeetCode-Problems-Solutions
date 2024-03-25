#include <vector>
#include <cmath>

class Solution {
public:
    std::vector<int> findDuplicates(std::vector<int>& nums) {
        std::vector<int> answer;

        for (int num : nums) {
            int arrIndex = abs(num) - 1;
            if (nums[arrIndex] > 0) nums[arrIndex] = -nums[arrIndex];
            else answer.emplace_back(abs(num));
        }

        return answer;
    }
};