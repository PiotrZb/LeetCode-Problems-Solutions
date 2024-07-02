#include <vector>

class Solution {
public:
    std::vector<int> intersect(std::vector<int>& nums1, std::vector<int>& nums2) {
        int freq[1001];
        std::vector<int> res;

        for (int num : nums1) freq[num]++;

        for (int num : nums2) {
            if (freq[num]) {
                res.emplace_back(num);
                freq[num]--;
            }
        }

        return res;
    }
};