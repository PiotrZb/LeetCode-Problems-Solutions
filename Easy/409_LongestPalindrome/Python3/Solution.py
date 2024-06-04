from collections import Counter

class Solution:
    def longestPalindrome(self, s: str, res=0) -> int:
        for count in Counter(s).values():
            res += count - (count & 1 and res & 1)
        return res