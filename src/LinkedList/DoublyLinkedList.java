package LinkedList;

// Definition for doubly-linked list.
class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int x) {val = x;}
}


public class DoublyLinkedList {

    private DoublyListNode head;
    /** Initialize your data structure here. */
    public DoublyLinkedList() {
        head = null;
    }


    /** Helper function to return the index-th node in the linked list. */
    private DoublyListNode getNode(int index) {
        DoublyListNode cur = head;
        for (int i = 0; i < index && cur != null; ++i) {
            cur = cur.next;
        }
        return cur;
    }


    /** Helper function to return the last node in the linked list. */
    private DoublyListNode getTail() {
        DoublyListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }


    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        DoublyListNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }


    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        DoublyListNode cur = getNode(index);
        if (cur == null) {
            return;
        }
        DoublyListNode prev = cur.prev;
        DoublyListNode next = cur.next;
        if (prev != null) {
            prev.next = next;
        } else {
            // modify head when deleting the first node.
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

}
