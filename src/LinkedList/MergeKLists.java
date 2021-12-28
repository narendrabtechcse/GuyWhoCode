package LinkedList;

/*
https://leetcode.com/problems/merge-k-sorted-lists/



You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.*/

public class MergeKLists {



    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0) return null;
            ListNode result = lists[0];

            for(int i=1;i<lists.length;i++){
                result = mergeList(result,lists[i]);
            }
            return result;
        }

        public ListNode mergeList(ListNode a , ListNode b){

            if(a==null) return b;
            if(b==null) return a;

            ListNode resultant;
            if(a.val<b.val){
                resultant = a;
                resultant.next = mergeList(a.next,b);
            }else{
                resultant = b;
                resultant.next = mergeList(a,b.next);
            }

            return resultant;
        }
    }




}






/* Solution discussion from LeetCode :-


    O(nk) solution : Take 2 lists at a time and merge it . Convert this problem to merging 2 liked list problem basically - Runtime: 228 ms

        ListNode merge (ListNode a , ListNode b) {
        if (a == null) return b ;
        if (b == null) return a;

        ListNode res ;
        if (a.val <= b.val) {
        res = a;
        res.next = merge(a.next , b);
        } else {
        res = b;
        res.next = merge (a, b.next);
        }
        return res;
        }
public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length ; ++i) {
        res = merge (res, lists[i]);
        }
        return res;
        }
        O(nlogk) solution : Apply divide and conquer technique like we do in merging 2 arrays using merge sort - Runtime: 2 ms

        ListNode merge (ListNode a , ListNode b) {
        if (a == null) return b ;
        if (b == null) return a;

        ListNode res ;
        if (a.val <= b.val) {
        res = a;
        res.next = merge(a.next , b);
        } else {
        res = b;
        res.next = merge (a, b.next);
        }
        return res;
        }
public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode res = mergeUtil(lists, 0 , lists.length - 1);
        return res;
        }

        ListNode mergeUtil(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        ListNode a = mergeUtil(lists, start, mid);
        ListNode b = mergeUtil(lists, mid + 1, end);
        return merge(a, b);
        }
        O(nlogk) solution : Improvement over previous solution. This is an iterative approach and thus takes less space internally - Runtime: 1 ms

        ListNode merge (ListNode a , ListNode b) {
        if (a == null) return b ;
        if (b == null) return a;

        ListNode res = new ListNode(0);
        ListNode head = res;
        while (a != null && b != null) {
        if (a.val <= b.val)
        {
        res.next = a;
        a = a.next;
        } else {
        res.next = b;
        b = b.next;
        }
        res = res.next;
        }
        while (a != null) {
        res.next = a;
        res = res.next;
        a = a.next;
        }
        while (b != null) {
        res.next = b;
        res = res.next;
        b = b.next;
        }
        return head.next;
        }
public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode res = mergeUtil(lists, 0 , lists.length - 1);
        return res;
        }

        ListNode mergeUtil(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        ListNode a = mergeUtil(lists, start, mid);
        ListNode b = mergeUtil(lists, mid + 1, end);
        return merge(a, b);
        }


        */