class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode lastNodeList2 = list2;
        ListNode currNode = list1;
        int index = 0;

        while (lastNodeList2.next != null) lastNodeList2 = lastNodeList2.next;

        while (true) {
            if (index == a - 1) {
                ListNode temp = currNode;
                currNode = currNode.next;
                temp.next = list2;
                break;
            }

            currNode = currNode.next;
            index++;
        }

        while (true) {
            index++;
            if (index == b) {
                lastNodeList2.next = currNode.next;
                break;
            }
            currNode = currNode.next;
        }

        return list1;
    }
}