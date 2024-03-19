import heapq
from collections import Counter

class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        counter = Counter(tasks)
        numberOfIntervals = len(tasks)
        heap = []

        for task, count in counter.items():
            heapq.heappush(heap, (-count, task))

        while True:
            numberOfTasksDone = 0
            temp = []

            while heap:
                # prioritize the most numerous task first 
                priority, task = heapq.heappop(heap)
                numberOfTasksDone += 1

                if priority < -1:
                    temp.append((priority + 1, task))

                if numberOfTasksDone > n:
                    break
            
            if temp:
                # idle
                numberOfIntervals += (n + 1 - numberOfTasksDone) if numberOfTasksDone <= n else 0

                for el in temp:
                    heapq.heappush(heap, el)
                    
            else:
                return numberOfIntervals
