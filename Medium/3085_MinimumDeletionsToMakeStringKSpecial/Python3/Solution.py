from collections import Counter

class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        res = float("inf")
        sortedFreqs = sorted(Counter(word).values())

        for f in sortedFreqs:
            temp = 0
            for f2 in sortedFreqs:
                temp += f2 if f2 < f else max(0, f2 - f - k)
            res = min(temp, res)

        return res
        