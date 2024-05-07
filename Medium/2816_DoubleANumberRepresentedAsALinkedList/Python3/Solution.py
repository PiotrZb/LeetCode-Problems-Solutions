from typing import Optional
from ListNode import ListNode

class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prevNode = None

        while head:
            temp = head
            head = head.next
            temp.next = prevNode
            prevNode = temp

        res = 0

        while prevNode:
            res, prevNode.val = divmod(prevNode.val * 2 + res, 10)
            temp = prevNode
            prevNode = prevNode.next
            temp.next = head
            head = temp
        
        if res:
            head = ListNode(res, head)
        
        return head

        # num = 0 

        # while head:
        #     num = num * 10 + head.val
        #     head = head.next

        # if not num:
        #     return ListNode()

        # num = num * 2
        # head = None

        # while num:
        #     num, val = divmod(num, 10)
        #     head = ListNode(val, head)
        
        # return head