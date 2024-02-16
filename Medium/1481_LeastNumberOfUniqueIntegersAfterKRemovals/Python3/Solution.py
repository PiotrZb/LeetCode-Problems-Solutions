from collections import Counter

class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        sortedFreq = sorted(list(Counter(arr).values()))
        numberOfUniqueInts = len(sortedFreq)
        for freq in sortedFreq:
            k -= freq
            if k < 0:
                break
            numberOfUniqueInts -= 1

        return numberOfUniqueInts