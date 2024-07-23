from collections import Counter

class Solution:
    def frequencySort(self, nums: list[int]) -> list[int]:
        return [num for num, count in sorted(Counter(nums).items(), key=lambda x: (x[1], -x[0])) for _ in range(count)]