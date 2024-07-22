from ListNode import ListNode
from typing import Optional

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = curr = ListNode()
        x = 0

        while l1 or l2 or x:
            temp = 0

            if l1:
                temp, l1 = l1.val, l1.next

            if l2:
                temp, l2 = temp + l2.val, l2.next

            x, temp = divmod(temp + x, 10)
            curr.next = ListNode(temp)
            curr = curr.next

        return dummy.next