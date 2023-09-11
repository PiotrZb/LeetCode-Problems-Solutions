class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        for i in range(int(len(s)/2)):
            if len(s) % (i + 1) == 0 and s == ''.join([s[0:i + 1] for x in range(int(len(s) / (i + 1)))]): return True
        return False