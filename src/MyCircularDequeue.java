public class MyCircularDequeue {
    //Design your implementation of the circular double-ended queue (deque).
    //
    //Your implementation should support following operations:
    //
    //MyCircularDeque(k): Constructor, set the size of the deque to be k.
    //insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
    //insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
    //deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
    //deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
    //getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
    //getRear(): Gets the last item from Deque. If the deque is empty, return -1.
    //isEmpty(): Checks whether Deque is empty or not.
    //isFull(): Checks whether Deque is full or not.
    //
    //Example:
    //
    //MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
    //circularDeque.insertLast(1);			// return true
    //circularDeque.insertLast(2);			// return true
    //circularDeque.insertFront(3);			// return true
    //circularDeque.insertFront(4);			// return false, the queue is full
    //circularDeque.getRear();  			// return 2
    //circularDeque.isFull();				// return true
    //circularDeque.deleteLast();			// return true
    //circularDeque.insertFront(4);			// return true
    //circularDeque.getFront();			// return 4

    public static void main(String[] args) {

        MyCircularDequeue circularDeque = new MyCircularDequeue(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1));	// return true
        System.out.println(circularDeque.insertLast(2));			// return true
        System.out.println(circularDeque.insertFront(3));			// return true
        System.out.println(circularDeque.insertFront(4));			// return false, the queue is full
        System.out.println(circularDeque.getRear());		// return 2
        System.out.println(circularDeque.isFull());				// return true
        System.out.println(circularDeque.deleteLast());			// return true
        System.out.println(circularDeque.insertFront(4));			// return true
        System.out.println(circularDeque.getFront());		// return 4

    }

    int size;
    int maxSize;
    DoubleLinkedNode head ;
    DoubleLinkedNode tail;
    public MyCircularDequeue(int s){
        head = new DoubleLinkedNode(-1);
        tail = new DoubleLinkedNode(-1);
        size =0;
        this.maxSize = s;
    }

    public class DoubleLinkedNode{
        int val;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        public DoubleLinkedNode(int value){
            this.val = value;
        }
    }

    public boolean insertFront(int value){
        DoubleLinkedNode insertNode = new DoubleLinkedNode(value);
        if (this.size== 0){
            head = insertNode;
            tail = insertNode;
            size++;
            return true;
        }else if (this.size == maxSize){
            return false;
        }

        insertNode.next = head;
        head.prev = insertNode;
        insertNode.prev = tail;;
        tail.next = insertNode;
        head = insertNode;
        size++;
        return true;

    }

    public boolean insertLast(int value){
        DoubleLinkedNode insertNode = new DoubleLinkedNode(value);
        if (this.size == 0){
            head = insertNode;
            tail = insertNode;
            size++;
            return true;
        }else if (this.size == maxSize){
            return false;
        }
        insertNode.prev = tail;
        insertNode.next = head;
        tail.next = insertNode;
        head.prev = insertNode;
        tail = insertNode;
        size++;
        return true;
    }

    public boolean deleteFront(){
        if (this.size == 0){
            return false;
        }
        if (this.size ==1){
            head = null;
            tail = null;
            size--;
            return true;
        }
        tail.next = head.next;
        head.next.prev = tail;
        head = head.next;
        size--;
        return true;



    }

    public boolean deleteLast(){
        if (this.size == 0){
            return false;
        }else if (this.size == 1){
            head = null;
            tail = null;
            size--;
            return true;

        }
        head.prev = tail.prev;
        tail.prev.next = head;
        tail = tail.prev;
        size--;
        return true;

    }

    public int getFront(){
        if (size == 0){
            return -1;
        }
        return head.val;

    }

    public int getRear(){
        if (size ==0){
            return -1;
        }
        return tail.val;

    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == maxSize;
    }

}
