public class PalindromeLinkedList {
    //Given a singly linked list, determine if it is a palindrome.
    //
    //Example 1:
    //
    //Input: 1->2
    //Output: false
    //Example 2:
    //
    //Input: 1->2->2->1
    //Output: true
    //Follow up:
    //Could you do it in O(n) time and O(1) space?
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast!= null){
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if (slow.val != fast.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;


    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!= null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;

    }
}
