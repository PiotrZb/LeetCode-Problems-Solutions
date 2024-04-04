#include <cmath>
#include <string>

class Solution {
public:
    int maxDepth(std::string s) {
        int maxDepth = 0, currDepth = 0;

        for (char c : s) {
            if (c == '(') {
                currDepth++;
                maxDepth = std::max(maxDepth, currDepth);
            }
            else if (c == ')') currDepth--;
        }

        return maxDepth; 
    }
};