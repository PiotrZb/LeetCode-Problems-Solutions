class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(), currNode = dummy;

        for (int sum = 0; head.next != null; head = head.next) {
            if (head.next.val == 0) {
                currNode = currNode.next = new ListNode(sum);
                sum = 0;
            }
            else sum += head.next.val;
        }

        return dummy.next;
    }
}