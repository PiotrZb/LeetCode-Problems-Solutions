#include <vector>

class Solution {
private:
    bool memo[100000]; // memo[i] == true ---> for current index == i there is no way to create a valid partition

public:
    bool validPartition(std::vector<int> &nums, int i = 0) {
        if (i == nums.size()) return true; // basic case
        if (this->memo[i]) return false;

        if (nums.size()- i > 1 && nums[i] == nums[i + 1]) { // first condition
            if (validPartition(nums, i + 2)) return true;
        }

        if (nums.size() - i > 2) {
            if ((nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) ||         // second condition
                (nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1)) { // third condition
                if (validPartition(nums, i + 3)) return true;
            }
        }

        return !(this->memo[i] = true);
    }
};