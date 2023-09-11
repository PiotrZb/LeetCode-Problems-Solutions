#include <vector>
#include <algorithm>
#include <cmath>

class Solution {
public:
    double findMaxAverage(std::vector<int>& nums, int k) {
        double maxAverage = -INFINITY, sum = 0;
        int lastElementIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (i >= k - 1) {
                maxAverage = std::max(maxAverage, sum / k);
                sum -= nums[lastElementIndex];
                lastElementIndex++;
            }
        }
        return maxAverage;
    }
};