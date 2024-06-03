class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        i, l = 0, len(t)
        for c in s:
            i += i < l and c == t[i]
        return l - i