#include <vector>
#include <limits.h>

class Solution {
public:
    bool increasingTriplet(std::vector<int>& nums) {
        int i = INT_MAX, j = i;
        for (auto num: nums){
            if (num <= i) i = num;
            else if (num <= j) j = num;
            else return true;
        }
        return false;
    }
};