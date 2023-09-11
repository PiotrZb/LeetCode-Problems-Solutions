#include <vector>

class Solution {
public:
    void moveZeroes(std::vector<int>& nums) {
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums[i];
            if (temp) {
                nums[i] = 0;
                nums[j] = temp;
                j++;
            }
        }
    }
};