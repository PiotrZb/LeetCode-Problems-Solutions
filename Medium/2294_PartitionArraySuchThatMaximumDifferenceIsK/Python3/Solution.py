class Solution:
    def partitionArray(self, nums: list[int], k: int) -> int:
        res = 0, last = -100001

        for num in sorted(set(nums)):
            if num - last > k:
                res += 1
                last = num

        return res