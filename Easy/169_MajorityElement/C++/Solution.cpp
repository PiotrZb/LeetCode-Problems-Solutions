#include <vector>

class Solution {
public:
    int majorityElement(std::vector<int>& nums) {
        int candidate = nums[0], votes = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == candidate) votes++; 
            else if (votes == 0) {
                candidate = nums[i];
                votes = 1;
            }
            else votes--;
        }

        return candidate;
    }
};