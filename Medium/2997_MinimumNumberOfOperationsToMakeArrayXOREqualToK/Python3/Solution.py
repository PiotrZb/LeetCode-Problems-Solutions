class Solution:
    def minOperations(self, nums: list[int], k: int) -> int:
        for num in nums:
            k = k ^ num
            
        return bin(k).count('1')