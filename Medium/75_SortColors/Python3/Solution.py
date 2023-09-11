class Solution:
    def sortColors(self, nums: List[int]) -> None:
        pointer_b = len(nums) - 1
        if not pointer_b: return
        pointer_a = pointer_c = 0
        while pointer_c <= pointer_b:
            if nums[pointer_c] == 0:
                nums[pointer_a], nums[pointer_c] = nums[pointer_c], nums[pointer_a]
                pointer_a += 1
                pointer_c += 1
            elif nums[pointer_c] == 2:
                nums[pointer_b], nums[pointer_c] = nums[pointer_c], nums[pointer_b]
                pointer_b -= 1
            else: pointer_c += 1