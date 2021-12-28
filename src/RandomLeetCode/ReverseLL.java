package RandomLeetCode;

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

        printList(head);


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

class Solution1 {
    public ListNode reverseList(ListNode head) {

        //1->2->3->4->5
        //5->4->3->2->1
        System.out.println("Initially List is : ");
        ListNode temp = head;
        // printList(temp);

        ListNode prev = head, curr = head;

        while (curr != null) {

            curr = curr.next;

            curr.next = null;

            curr.next = prev;

            prev = curr;


        }
        head.next = null;
        head = prev;



        return head;
    }


}
