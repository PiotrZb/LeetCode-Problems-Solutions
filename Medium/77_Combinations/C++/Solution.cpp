#include <vector>

class Solution {
public:
    std::vector<std::vector<int>> combine(int n, int k) {
        std::vector<std::vector<int>> allCombinations;
        std::vector<int> combination;
        recursion(n, k, 1, combination, allCombinations);
        return allCombinations;
    }

private:
    void recursion(int n, int k, int i, std::vector<int>& combination, std::vector<std::vector<int>>& allCombinations) {
        for(i; i <= n - k + 1; i++){
            combination.emplace_back(i);
            if(k > 1){ recursion(n, k - 1, i + 1, combination, allCombinations); }
            else{ allCombinations.emplace_back(combination); }
            combination.pop_back();
        }
    }
};