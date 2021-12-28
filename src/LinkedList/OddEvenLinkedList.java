package LinkedList;



/*

https://leetcode.com/problems/odd-even-linked-list/
369

Add to List

Share
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 */

public class OddEvenLinkedList {

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

        ListNode temp = oddEvenList(head);

        System.out.println();
        System.out.println("Finally The List Will Be : - ");
        printList(temp);

    }

    public static ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null )
            return head;

        ListNode oddList=null,evenStart=null,oddStart=null,evenList=null;
        int length = Length(head);
        ListNode curr=head,forward=null;

        for(int i = 1;i<=length;i++){
            forward = curr.next;
            curr.next = null;

            if(i%2==0){
                if(evenList==null) {
                    evenList = curr;
                    evenStart = evenList;
                    printList(evenStart);
                }
                else {
                    evenList.next = curr;
                    evenList = evenList.next;
                }
            }else{
                if(oddList==null) {
                    oddList = curr;
                    oddStart = oddList;
                }
                else {
                    oddList.next = curr;
                    oddList = oddList.next;
                }
            }
            curr = forward;
        }
        oddList.next = evenStart;

        return oddStart;
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


    public static void printList(ListNode head1) {
        ListNode head = head1;
        StringBuffer sb = new StringBuffer();
        sb.append(head.val).append("-->"); // read data from current element
        while(head.next!=null){               // if there is next element
            head = head.next;                 // visit it
            sb.append(head.val).append("-->");// and read its data
        };
        System.out.println(sb.toString());
    }
}



