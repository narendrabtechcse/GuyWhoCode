package LinkedList;

/*
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the
beginning and the kth node from the end (the list is 1-indexed).
 */

public class SwapLLAtKth {

    static ListNode tempHead=null,tempTail = null;

    static ListNode origHead=null,origTail = null;

    public static void main(String[] args) {
        ListNode head = null;
        ListNode l1 = new ListNode(1, null);
        head = l1;
        ListNode l2 = new ListNode(2, null);
        l1.next = l2;
        ListNode l3 = new ListNode(3, null);
        l2.next = l3;
        ListNode l4 = new ListNode(4, null);
        l3.next = l4;
        ListNode l5 = new ListNode(5, null);
        l4.next = l5;

        System.out.println("Initially The List Will Be : - ");
        printList(head);

        ListNode temp = reverseKGroup(head,2);

        System.out.println();
        System.out.println("Finally The List Will Be : - ");
        printList(temp);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = Length(head);
        ListNode start=head,end=head,prevStart=head,prevEnd = head ;

        int i=1;
        while(i<k){
            //prevEnd = end;
            start = start.next;
            i++;
        }
        prevEnd = start;

        while(prevEnd.next!=null){
            end = end.next;
            prevEnd = prevEnd.next;
        }

        int temp = 0;
        temp = start.val;
        start.val = end.val;
        end.val = temp;
       return head;

    }

    static int Length(ListNode head){
        int length=0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }

        return length;
    }


    static void addFirst(ListNode node){
        if(tempHead==null){
            tempHead = node;
            tempTail = node;
        }else{
            node.next = tempHead;
            tempHead = node;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
    }
}


