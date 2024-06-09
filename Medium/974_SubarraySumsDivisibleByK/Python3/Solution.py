from collections import defaultdict

class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        remCount = defaultdict(int) # {reminder : count}
        remCount[0] = 1
        rem = res = 0

        for num in nums:
            rem = (rem + num) % k
            res += remCount[rem]
            remCount[rem] += 1
        
        return res