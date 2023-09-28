#include <vector>
#include <deque>
#include <algorithm>

// Deque
class Solution {
public:
    std::vector<int> sortArrayByParity(std::vector<int>& nums) {
        std::deque<int> dq = {};

        for(int num : nums) {
            if (num & 1) dq.push_back(num);
            else dq.push_front(num);
        }

        return std::vector(dq.begin(), dq.end());
    }
};

// Two pointers
class Solution {
public:
    std::vector<int> sortArrayByParity(std::vector<int>& nums) {
        int p1 = 0, p2 = nums.size();

        while(p1 < p2) {
            if (nums[p1] & 1) {
                p2--;
                std::swap(nums[p1], nums[p2]);
            } else p1++;
        }

        return nums;
    }
};

// std::partition
class Solution {
public:
    std::vector<int> sortArrayByParity(std::vector<int>& nums) {
        std::partition(nums.begin(), nums.end(), [](int num){return (num & 1) == 0;});
        return nums;
    }
};

// std::sort
class Solution {
public:
    std::vector<int> sortArrayByParity(std::vector<int>& nums) {
        std::sort(nums.begin(), nums.end(), [](int a, int b){return (a & 1) < (b & 1);});
        return nums;
    }
};

// two arrays
class Solution {
public:
    std::vector<int> sortArrayByParity(std::vector<int>& nums) {
        std::vector<int> e, o;

        for(int num : nums) {
            if (num & 1) o.push_back(num);
            else e.push_back(num);
        }

        for (int num : o) e.push_back(num);

        return e;
    }
};