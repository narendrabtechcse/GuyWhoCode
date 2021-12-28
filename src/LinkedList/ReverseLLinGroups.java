package LinkedList;

/*

https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes
(i.e., only nodes themselves may be changed.)

 */

public class ReverseLLinGroups {

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

        if(head==null || head.next==null || k==0 )
            return head;

        int length = Length(head);
        ListNode forward ;
        ListNode current=head;
        while(length>=k){

            int tempK = k;

            while(tempK-- > 0){
                forward = current.next;
                current.next =null;
                addFirst(current);
                current = forward;
            }




            if(origHead==null){
                origHead = tempHead;
                origTail = tempTail;
            }else{
                origTail.next = tempHead;
                origTail = tempTail;

            }

            tempHead = null;
            tempTail = null;
            length -=k;

        }


            origTail.next = current;


        return origHead;

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


