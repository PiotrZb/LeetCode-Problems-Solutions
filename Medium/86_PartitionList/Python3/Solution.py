import ListNode

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        if not head: return None

        left, right = [], []
        while head:
            if head.val < x: left.append(head)
            else: right.append(head)
            head = head.next
        
        left = left + right
        left[-1].next = None
        for i in range(len(left) - 1):
            left[i].next = left[i+1]
        
        return left[0]
    
# Version II -> Memory 98.91%
# class Solution:
#     def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
#         if not head: return None

#         left, right = ListNode(), ListNode()
#         currentLeft, currentRight = left, right
#         while head:
#             if head.val < x: 
#                 currentLeft.next = head
#                 currentLeft = currentLeft.next
#             else: 
#                 currentRight.next = head
#                 currentRight = currentRight.next
#             head = head.next
        
#         currentLeft.next = right.next
#         currentRight.next = None
        
#         return left.next