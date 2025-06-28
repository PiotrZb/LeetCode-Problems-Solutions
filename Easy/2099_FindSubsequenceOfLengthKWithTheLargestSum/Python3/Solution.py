import heapq

class Solution:
    def maxSubsequence(self, nums: list[int], k: int) -> list[int]:
        return [num for _, num in sorted(heapq.nlargest(k, [(i, num) for i, num in enumerate(nums)], key=lambda x : x[1]), key=lambda x : x[0])]