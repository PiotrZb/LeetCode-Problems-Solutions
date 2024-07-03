from heapq import nlargest, nsmallest

class Solution:
    def minDifference(self, nums: list[int]) -> int:
        if len(nums) < 5:
            return 0
        
        maxValues, minValues = nlargest(4, nums), nsmallest(4, nums)

        return min(maxValues[0] - minValues[3],
                   maxValues[1] - minValues[2],
                   maxValues[2] - minValues[1],
                   maxValues[3] - minValues[0])