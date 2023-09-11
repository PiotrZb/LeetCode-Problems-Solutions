#include <vector>
#include <algorithm>

class Solution {
public:
    int longestSubarray(std::vector<int> &nums) {
        int l = -1, previousLen = 0, maxLen = 0, r = 0;
        for (r; r < nums.size(); r++) {
            if (!nums[r]) {
                int len = r - l - 1;
                maxLen = std::max(maxLen, len + previousLen);
                previousLen = len;
                l = r;
            }
        }
        maxLen = std::max(maxLen, previousLen + r - l - 1);
        return maxLen < nums.size() ? maxLen : maxLen - 1;
    }
};