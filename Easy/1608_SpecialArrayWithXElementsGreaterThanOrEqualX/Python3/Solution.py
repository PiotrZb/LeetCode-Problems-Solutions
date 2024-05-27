class Solution:
    def specialArray(self, nums: list[int]) -> int:
        for i in range(len(nums) + 1):
            count = sum(1 for num in nums if num >= i)
            if count == i:
                return i

        return - 1