class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        self.nums = sorted(nums)
        self.numsLen = len(nums)
        self.maxDiff = self.nums[-1] - self.nums[0]
        self.p = p
        return self.findTh()

    def findNumberOfPairs(self, th: int) -> int:
        number = i = 0
        while i < self.numsLen - 1:
            diff = self.nums[i + 1] - self.nums[i]
            if diff <= th:
                number += 1
                i += 2
            else: i += 1
        return number
        
    def findTh(self) -> int:
        l = 0 
        r = self.maxDiff
        while l < r:
            mid = (l + r) // 2
            if self.findNumberOfPairs(mid) < self.p: l = mid + 1
            else: r = mid
        return l