class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        # single line solution
        #return int((sum(nums) - sum(set(nums)))/(len(nums) - len(set(nums))))

        # Floyd's cycle detection algorithm (Tortoise and hare)
        s = nums[0]
        f = nums[nums[0]]

        # finding the meeting point
        while f != s:
            s = nums[s]
            f = nums[nums[f]]

        # finding the cycle starting point
        s = 0
        while s != f:
            s = nums[s]
            f = nums[f]

        return s