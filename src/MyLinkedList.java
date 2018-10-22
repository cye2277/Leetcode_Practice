public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
        for (int i  =0; i<linkedList.length;i++){
            System.out.println(linkedList.get(i));
        }

        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
        for (int i  =0; i<linkedList.length;i++){
            System.out.println(linkedList.get(i));
        }




    }

    //Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list.
    //A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
    //If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.


    static class Node{
        int val;
        Node next;
        Node(int value){
            this.val = value;
        }
    }

    Node head = null;
    Node end = null;
    private int length = 0;
    public MyLinkedList() {}

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index <= 0){
            return head.val;
        }
        if (length ==0 || index > length-1){
            return -1;
        }
        int idx = 1;
        Node result = head.next;
        while (idx < index){
            result = result.next;
            idx++;
        }
        return result.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(length,val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0|| index >length){
            return;
        }
        Node newNode = new Node(val);
        Node oldNodeAtIndex = head;
        Node prev = null;
        for (int i =0; i < index; i++){
            prev = oldNodeAtIndex;
            oldNodeAtIndex = oldNodeAtIndex.next;
        }
        if (index == 0){
            newNode.next = head;
            head = newNode;
            if (length == 0){
                end = newNode;
            }
        }else if (index ==length){
            end.next = newNode;
            end = newNode;
            if (length == 0){
                head = newNode;
            }
        }else{
            prev.next = newNode;
            newNode.next = oldNodeAtIndex;
        }
        length++;


    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length){
            return;
        }

        Node nodeNeedDelete = head;
        Node prev = null;
        for (int i =0; i < index;i++){
            prev = nodeNeedDelete;
            nodeNeedDelete = nodeNeedDelete.next;
        }
        if (index == 0){
            head = head.next;
        }else{
            prev.next = nodeNeedDelete.next;
        }
        length--;




    }

}
