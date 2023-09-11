#include <algorithm>
#include <vector>

class Solution {
public:
    std::vector<bool> kidsWithCandies(std::vector<int>& candies, int extraCandies) {
        int maxVal = *std::max_element(candies.begin(), candies.end());
        std::vector<bool> answer(candies.size());
        for (int i = 0; i < candies.size(); i++) answer[i] = candies[i] + extraCandies >= maxVal;
        return answer;
    }
};