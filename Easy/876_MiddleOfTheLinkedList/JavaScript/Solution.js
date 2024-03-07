import ListNode from "./ListNode.js"

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
    let midPointer = head;

    while (head !== null && head.next !== null) {
        midPointer = midPointer.next;
        head = head.next.next;
    }

    return midPointer;
};