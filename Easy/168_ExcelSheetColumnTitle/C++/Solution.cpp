#include <string>
#include <cmath>

class Solution {
public:
    std::string convertToTitle(int columnNumber) {
        // char alphabet[26];
        // alphabet[0] = 'Z';
        // for (int i = 1; i < 26; i++) alphabet[i] = static_cast<char>(static_cast<int>('A') + i - 1);

        const char alphabet[26] = {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};
        std::string answer = "";
        div_t res;

        while (columnNumber > 0) {
            res = div(columnNumber, 26);
            columnNumber = res.rem == 0 ? res.quot - 1 : res.quot;
            answer = alphabet[res.rem] + answer;
        }

        return answer;
    }
};