const ListNode = require('ListNode.js');

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    //Two pointers
    let leftPointer = head;
    let rightPointer = head;

    for (let i = 0; i < n; i++) rightPointer = rightPointer.next;
    
    if (rightPointer === null) return leftPointer.next;

    rightPointer = rightPointer.next;

    while (rightPointer !== null) {
        leftPointer = leftPointer.next;
        rightPointer = rightPointer.next;
    }

    leftPointer.next = leftPointer.next.next;

    return head;

    // Trivial solution
    // const list = [];
    // while (head !== null) {
    //     list.push(head);
    //     head = head.next;
    // }

    // const l = list.length;

    // if (l === 1) return null;
    // if (l === n) return list[1];
    // if (n === 1) list[l - 2].next = null;
    // else list[l - n - 1].next = list[l - n + 1];

    // return list[0];
};