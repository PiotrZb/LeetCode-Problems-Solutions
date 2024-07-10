#include <vector>
#include <string>

class Solution {
public:
    int minOperations(std::vector<std::string>& logs) {
        int res = 0;
        for (std::string& log : logs) res += log == "../" ? -(res > 0) : log != "./";
        return res;
    }
};