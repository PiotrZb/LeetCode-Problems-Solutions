#include <vector>

class Solution {
public:
    bool canPlaceFlowers(std::vector<int>& flowerbed, int n) {
        if (!n) { return true; }
        flowerbed.emplace_back(0);
        flowerbed.insert(flowerbed.begin(), 0);
        int numberOfAveliablePlots = 0;
        for (int i = 1; i < flowerbed.size() - 1; i++) {
            if (!flowerbed[i] && !flowerbed[i - 1] && !flowerbed[i + 1]) { 
                numberOfAveliablePlots++;
                if (numberOfAveliablePlots == n) { return true; }
                flowerbed[i] = 1;
            }
        }
        return false;
    }
};