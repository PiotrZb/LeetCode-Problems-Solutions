class Solution:
    def __init__(self):
        self.memo = {}
        
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        if not s: return True
        if s in self.memo: return self.memo[s]
        for word in wordDict:
            if word in s:
                resultWords = s.split(word, 1)
                self.memo[s] = self.wordBreak(resultWords[0], wordDict) and self.wordBreak(resultWords[1], wordDict)
                if self.memo[s]: return True
        return False