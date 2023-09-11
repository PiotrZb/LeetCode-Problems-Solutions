class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode temp, nextNode = head.next;
        head.next = null;
        while (nextNode != null) {
            temp = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            nextNode = temp;
        }   

        return head;
    }
}