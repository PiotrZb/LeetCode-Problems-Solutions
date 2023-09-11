#include <string>

class Solution {
public:
    bool isSubsequence(std::string s, std::string t) {
        if (s == t){ return true; }

        int i = 0, j = 0;

        while(j < t.size()){
            if (s[i] == t[j]){ i++; }
            if (i >= s.size()){ return true; }
            j++;
        }

        return false;
    }
};