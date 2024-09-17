from collections import defaultdict

class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> list[str]:
        d = defaultdict(int)

        for word in (s1 + s2).split(' '):
            d[word] += 1

        return [x for x in d.keys if d[x] == 1]