class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        m = set()
        c = 0
        for n in nums:
            if n not in m:
                c += self.countAllPossiblePairs(nums.count(n))
                m.add(n)
        return c
    
    def countAllPossiblePairs(self, k: int) -> int:
        if k < 2: return 0
        if k == 2: return 1
        return k - 1 + self.countAllPossiblePairs(k - 1)