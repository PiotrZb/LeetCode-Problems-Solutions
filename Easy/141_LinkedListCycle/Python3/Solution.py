import ListNode

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        while head:
            if head.val == 100001: return True
            head.val = 100001
            head = head.next
        return False