class Solution:
    def sortColors(self, nums: list[int]) -> None:
        i = j = 0
        k = len(nums) - 1

        while j <= k:
            if nums[j] < 1:
                nums[j], nums[i] = nums[i], nums[j]
                i += 1
            elif nums[j] > 1:
                nums[j], nums[k] = nums[k], nums[j]
                k -= 1
                continue
            j += 1