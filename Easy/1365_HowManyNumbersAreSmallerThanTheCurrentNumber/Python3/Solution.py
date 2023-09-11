class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        m = {}
        a = []
        for n in nums:
            if n in m.keys(): a.append(m[n])
            else:
                c = 0
                for k in nums: 
                    if k < n: c += 1
                m[n] = c
                a.append(c)
        return a