import ListNode

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1 and not list2: return None
        elif not list1: return list2
        elif not list2: return list1

        if list1.val <= list2.val:
            currentNode1 = list1
            currentNode2 = list2
        else:
            currentNode1 = list2
            currentNode2 = list1

        while True:
            if not currentNode1.next:
                currentNode1.next = currentNode2
                return list1 if list1.val <= list2.val else list2
            elif currentNode1.next.val > currentNode2.val:
                tempNode = currentNode1.next
                currentNode1.next = currentNode2
                currentNode2 = tempNode
            else:
                currentNode1 = currentNode1.next