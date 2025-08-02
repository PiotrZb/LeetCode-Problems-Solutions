from collections import Counter

class Solution:
    def minCost(self, basket1: list[int], basket2: list[int]) -> int:
        minEl = min(min(basket1), min(basket2))
        elements = set(basket1).union(basket2)
        counter1 = Counter(basket1)
        counter2 = Counter(basket2)
        swappArr = []
        cost = 0

        for e in elements:
            count1 = counter1.get(e, 0)
            count2 = counter2.get(e, 0)
            diff = abs(count1 - count2)

            if not diff:
                continue

            if diff % 2:
                return -1

            swappArr.extend([e] * int(diff/2))
            
        
        if len(swappArr):
            swappArr.sort()
            for i in range(len(swappArr) // 2):
                cost += min(2 * minEl, swappArr[i])
        
        return cost