package LinkedList;

/*
https://leetcode.com/problems/reverse-linked-list/

Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseLLAddFirst {

    static ListNode tempHead=null,tempTail = null;

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

        ListNode temp = reverseList(head);

        System.out.println();
        System.out.println("Finally The List Will Be : - ");
        printList(temp);

    }

    public static ListNode reverseList(ListNode head) {
        //1->2->3->4->5
        //5->4->3->2->1

        ListNode curr=head,forward=null;
        while(curr!=null){
            forward=curr.next;
            curr.next = null;
            addFirst(curr);
            curr=forward;
        }
        return tempHead;
    }

    public static void addFirst(ListNode node) {
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


