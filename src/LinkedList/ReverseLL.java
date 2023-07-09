package LinkedList;

/*
https://leetcode.com/problems/reverse-linked-list/

Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseLL {
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

        ListNode prev=null,curr=null;
        while(head!=null){
            curr=head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

