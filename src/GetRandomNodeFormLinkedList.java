import java.util.Random;

public class GetRandomNodeFormLinkedList {
    public static void main(String[] args) {

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    Random random;
    ListNode head;
    public GetRandomNodeFormLinkedList(ListNode h){
        random = new Random();
         head = h;
    }
    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for (int i =1; c.next!= null; i++){
            c = c.next;
            if (random.nextInt(i+1) ==i){
                r = c.val;
            }
        }
        return r;


    }

}
