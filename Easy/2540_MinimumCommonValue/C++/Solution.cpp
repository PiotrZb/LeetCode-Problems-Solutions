#include <vector>

class Solution {
public:
    int getCommon(std::vector<int>& nums1, std::vector<int>& nums2) {
        int pointer1 = 0, pointer2 = 0;
        
        while (pointer1 < nums1.size() && pointer2 < nums2.size()) {
            if (nums1[pointer1] == nums2[pointer2]) return nums1[pointer1];
            if (nums1[pointer1] > nums2[pointer2]) pointer2++;
            else pointer1++;
        }

        return -1;
    }
};