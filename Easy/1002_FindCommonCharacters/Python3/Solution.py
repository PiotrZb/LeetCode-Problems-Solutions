from collections import Counter
from functools import reduce

class Solution:
    def commonChars(self, words: list[str]) -> list[str]:
        return reduce(lambda x, y : x & y, map(Counter, words)).elements()