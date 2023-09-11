#include <string>

class Solution {
public:
    std::string reverseVowels(std::string s) {
        int lastVowelIndex = s.size() - 1; 
        for (int i = 0; i < lastVowelIndex; i++){
            if (isVowel(s[i])){
                while (!isVowel(s[lastVowelIndex])) lastVowelIndex--;
                char temp = s[i];
                s[i] = s[lastVowelIndex];
                s[lastVowelIndex] = temp;
                lastVowelIndex--;
            }
        }
        return s;
    }

    bool isVowel(char c) {
        c = std::tolower(c);
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }
};