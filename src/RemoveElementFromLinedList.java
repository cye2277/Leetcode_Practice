public class RemoveElementFromLinedList {
    //Remove all elements from a linked list of integers that have value val.
    //
    //Example:
    //
    //Input:  1->2->6->3->4->5->6, val = 6
    //Output: 1->2->3->4->5

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

    }


    public ListNode removeElements2(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }
}
