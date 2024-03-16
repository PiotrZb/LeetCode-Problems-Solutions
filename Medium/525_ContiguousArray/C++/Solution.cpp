#include <vector>
#include <unordered_map>

class Solution {
public:
    int findMaxLength(std::vector<int>& nums) {
        int maxLen = 0, balance = 0;
        std::unordered_map<int,int> balances;

        for (int i = 0; i < nums.size(); i++) {
            balance += nums[i] ? 1 : -1;
            if (!balance) maxLen = i + 1;
            else if (balances.find(balance) != balances.end()) {
                maxLen = std::max(maxLen, i - balances[balance]);
            }
            else {
                balances[balance] = i;
            }
        }

        return maxLen;
    }
};