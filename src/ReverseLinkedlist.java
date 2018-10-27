public class ReverseLinkedlist {
    //Reverse a singly linked list.
    //
    //Example:
    //
    //Input: 1->2->3->4->5->NULL
    //Output: 5->4->3->2->1->NULL
    //Follow up:
    //
    //A linked list can be reversed either iteratively or recursively. Could you implement both?
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next =  node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;




    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    //method1
    //iterative
    //time complexity: O(n)
    //space complexity: O(1)
    public static ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode newHead = null;
        while (head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    //method2
    //recursion
    //time complexity: O(n)
    //space complexity: O(1)

    public static ListNode reverseList2(ListNode head){
        return reverseListInt(head, 0);
    }

    public static ListNode reverseListInt(ListNode head, ListNode newhead){
        if (head == null){
            return newhead;
        }
        ListNode next = head.next;
        head.next = newhead;
        return reverseListInt(next,head);
    }
}
