package LinkedList;


 class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}

public class MyLinkedList {
    int size;
    ListNode1 head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode1(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode1 curr = head;
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index > size) return;

        if (index < 0) index = 0;

        ++size;

        ListNode1 pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        ListNode1 toAdd = new ListNode1(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        size--;
        ListNode1 pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        pred.next = pred.next.next;
    }
}