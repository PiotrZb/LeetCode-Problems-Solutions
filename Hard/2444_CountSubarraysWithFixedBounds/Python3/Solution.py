class Solution:
    def countSubarrays(self, nums: list[int], minK: int, maxK: int) -> int:
        subarray = []
        count = 0
        nums.append(-1)

        for num in nums:
            if minK <= num <= maxK:
                subarray.append(num)
            
            else:
                maxIndex = minIndex = -1

                for index, n in enumerate(subarray):
                    if n == minK:
                        minIndex = index
                    
                    if n == maxK:
                        maxIndex = index

                    count += min(maxIndex, minIndex) + 1

                subarray = []

        return count