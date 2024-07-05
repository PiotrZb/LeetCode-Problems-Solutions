from ListNode import ListNode
from typing import Optional


class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> list[int]:
        prevDiff = index = firstPoint = prevPoint = 0
        minDiff = float('inf')

        while head.next:
            currDiff = head.next.val - head.val
            
            if currDiff * prevDiff < 0:
                firstPoint = index if not firstPoint else firstPoint
                minDiff = min(minDiff, index - prevPoint) if prevPoint else minDiff
                prevPoint = index

            prevDiff = currDiff
            head = head.next
            index += 1

        return [minDiff if minDiff != float('inf') else -1, 
                prevPoint - firstPoint if prevPoint != firstPoint else -1]