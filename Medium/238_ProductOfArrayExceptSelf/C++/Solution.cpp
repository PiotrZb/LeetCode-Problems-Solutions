#include <vector>

class Solution {
public:
    std::vector<int> productExceptSelf(std::vector<int>& nums) {
        std::vector<int> prefixes = {1}, postfixes = {1};
        int len = nums.size();
        for (int i = 0; i < len - 1; i++) {
            prefixes.emplace_back(nums[i] * prefixes[i]);
            postfixes.emplace_back(nums[len - 1 - i] * postfixes[i]);
        }      
        std::vector<int> answer;
        for (int i = 0; i < len; i++) answer.emplace_back(prefixes[i] * postfixes[postfixes.size() - 1 - i]);
        return answer;
    }
};