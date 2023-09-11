class Solution:
    def minimumDeleteSum(self, s1: str, s2: str, memo={}) -> int:
        if s1 == s2: return 0
        key = (s1, s2)
        if key not in memo:
            if not s1: memo[key] = sum(ord(c) for c in s2)
            elif not s2: memo[key] = sum(ord(c) for c in s1)
            elif s1[0] == s2[0]: memo[key] = self.minimumDeleteSum(s1[1:], s2[1:], memo)
            else: memo[key] = min(ord(s1[0]) + self.minimumDeleteSum(s1[1:], s2, memo), ord(s2[0]) + self.minimumDeleteSum(s1, s2[1:], memo))
        return memo[key]