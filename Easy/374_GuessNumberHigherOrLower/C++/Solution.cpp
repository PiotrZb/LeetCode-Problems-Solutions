class Solution {
public:
    int guessNumber(int n) {
        int mid, answer = 2, l = 1, r = n;

        while (answer != 0) {
            mid = l + (r - l) / 2;
            answer = guess(mid);
            if (answer == 1) l = mid + 1;
            else if (answer == -1) r = mid - 1;
        }

        return mid;
    }
};