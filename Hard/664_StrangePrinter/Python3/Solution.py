class Solution:
    def __init__(self):
        self.memo = {}

    def strangePrinter(self, s: str) -> int:
        if s in self.memo: return self.memo[s]
        l = len(s)
        if l == 1: return 1

        minNumberOfTurns = float('inf')
        for k in range(1, l):
            if s[0] == s[l - 1]: minNumberOfTurns = min(minNumberOfTurns, self.strangePrinter(s[:k]) + self.strangePrinter(s[k:l]) - 1)
            else: minNumberOfTurns = min(minNumberOfTurns, self.strangePrinter(s[:k]) + self.strangePrinter(s[k:l]))

        self.memo[s] = minNumberOfTurns
        return minNumberOfTurns