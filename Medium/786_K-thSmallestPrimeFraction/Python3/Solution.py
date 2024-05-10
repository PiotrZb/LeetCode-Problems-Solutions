import heapq

class Solution:
    def kthSmallestPrimeFraction(self, arr: list[int], k: int) -> list[int]:
        pq = []

        for i, n in enumerate(arr):
            heapq.heappush(pq, (n / arr[-1], i, len(arr) - 1))

        while k > 1:
            _, ni, di = heapq.heappop(pq)
            k -= 1
            if ni < di - 1:
                heapq.heappush(pq, (arr[ni] / arr[di - 1], ni, di - 1))
        
        _, ni, di = heapq.heappop(pq)
        return [arr[ni], arr[di]]