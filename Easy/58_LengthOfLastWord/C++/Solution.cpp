#include <string>
#include <cctype>

class Solution {
public:
    int lengthOfLastWord(std::string s) {
        int index = s.length() - 1, answer = 0;
        while (std::isspace(s[index])) index--;
        while (index >= 0 && !std::isspace(s[index])) {
            answer++;
            index--;
        }
        return answer;
    }
};