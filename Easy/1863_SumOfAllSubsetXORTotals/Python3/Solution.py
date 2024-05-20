class Solution:
    def subsetXORSum(self, nums: list[int]) -> int:
        res = 0
        for num in nums:
            res |= num
        return res << len(nums) - 1