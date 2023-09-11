//import java.math.BigInteger;

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;

        while(nextNode != null) {
            currentNode.next = new ListNode(this.gcd(currentNode.val, nextNode.val), nextNode);
            // *** using BigInteger gcd function ***
            // currentNode.next = new ListNode(BigInteger.valueOf(currentNode.val).gcd(BigInteger.valueOf(nextNode.val)).intValue(), nextNode);
            currentNode = nextNode;
            nextNode = nextNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        int rem;
        do {
            rem = a % b;
            a = b;
            b = rem;
        } while (rem != 0);
        return a;

        // *** recursive version ***
        // int rem = a % b;
        // if(rem == 0) return b;
        // return this.gcd(b, rem);
        // *** or shorter... *** 
        //return b == 0 ? a : this.gcd(b, a % b);
    }
}