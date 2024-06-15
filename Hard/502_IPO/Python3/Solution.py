import heapq


class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: list[int], capital: list[int]) -> int:
        projects = sorted(zip(capital, profits))
        i, n = 0, len(profits)
        heap = []

        for _ in range(k):
            while i < n and w >= projects[i][0]:
                heapq.heappush(heap, -projects[i][1])
                i += 1
            
            if not heap: 
                break
            
            w -= heapq.heappop(heap)
        
        return w