class Solution:
    def findKDistantIndices(self, nums: list[int], key: int, k: int) -> list[int]:
        jArr = [i for i, num in enumerate(nums) if num == key]
        res = []

        for i in range(len(nums)):
            isDistant = True

            for j in jArr:
                if abs(i - j) > k:
                    isDistant = False
                    break
            if isDistant:    
                res.append(i)

        return res