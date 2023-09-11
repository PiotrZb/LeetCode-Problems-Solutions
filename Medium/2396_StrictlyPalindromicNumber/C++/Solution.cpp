// #include <vector>

// class Solution {
// public:
//     bool isStrictlyPalindromic(int n) {
//         std::vector<int> representation;

//         for (int base = 2; base < n - 1; base++) {
//             representation.clear();
//             this->generateRepresentation(n, base, representation);
//             if (!this->isPalindromic(representation)) return false;
//         }

//         return true;
//     }

// private:
//     static void generateRepresentation(int n, int base, std::vector<int>& representation) {
//         while (n > 0) {
//             representation.emplace_back(n % base);
//             n = n / base;
//         }
//     }

// private:
//     static bool isPalindromic(const std::vector<int>& representation) {
//         int start = 0, end = representation.size() - 1;

//         while (start < end) {
//             if (representation[start] != representation[end]) return false;
//             start++;
//             end--;
//         }

//         return true;
//     }
// };

// *** why is it always false ??? ***
// let's consider the biggest base -> n - 2
// conversion to base n - 2:
// step 1: n : (n - 2) = 1 remainder is always 2 (for n >= 4)
// step 2: 1 : (n - 2) = 0 remainder is always 1 (for n >= 4)
// as we can see for n >= 4 representation is always equal '12' which is obviously not palindromic

class Solution {
public:
    bool isStrictlyPalindromic(int n) { return false; }
};