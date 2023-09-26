#include <vector>
#include <cmath>

class Solution {
public:
    std::vector<int> asteroidCollision(std::vector<int>& asteroids) {
        std::vector<int> answer;
        
        for (auto &asteroid : asteroids) {
            bool asteroid_destroyed = false;

            while(!answer.empty() && answer.back() > 0 && asteroid < 0) {
                if (answer.back() == abs(asteroid)) {
                    asteroid_destroyed = true;
                    answer.pop_back();
                    break;
                } else if (answer.back() > abs(asteroid)) {
                    asteroid_destroyed = true;
                    break;
                } else answer.pop_back();
            }

            if (!asteroid_destroyed) answer.push_back(asteroid);
        }

        return answer;
    }
};