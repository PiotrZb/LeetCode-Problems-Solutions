class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        x = {}
        for i in range(len(nums)):
            y = target - nums[i]
            if y in x and x[y] != i: return [i, x[y]]
            x[nums[i]] = i