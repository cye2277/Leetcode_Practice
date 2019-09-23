public class AddTwoNumbers {
    //You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    //
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    //
    //Example:
    //
    //Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    //Output: 7 -> 0 -> 8
    //Explanation: 342 + 465 = 807.

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;
        while (p != null || q != null){
            int i = p != null ? p.val: 0;
            int j = q != null ? q.val: 0;
            int sum = (i + j + carry) % 10;
            carry = (i + j + carry) / 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;

        }
        if (carry >0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
