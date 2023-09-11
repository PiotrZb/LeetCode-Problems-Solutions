import heapq
from queue import PriorityQueue

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        return sorted(nums)[len(nums) - k]

# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         q = PriorityQueue()
#         for num in nums:
#             if q.qsize() < k: q.put(num)
#             elif num > q.queue[0]:
#                 q.get()
#                 q.put(num)
#         return q.queue[0]
    
# class Solution:
#     def findKthLargest(self, nums: List[int], k: int) -> int:
#         heap = []
#         for num in nums:
#             heapq.heappush(heap, num)
#             if len(heap) > k:
#                 heapq.heappop(heap)
#         return heap[0]