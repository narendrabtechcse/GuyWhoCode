package Test;

class Node{
    int val;
    Node next;

    Node(int val)
    {
        this.val=val;
    }
}

public class CircularLL {

    Node start = null;

    Node prev = null;

    public void insertIntoLL(int val)
    {
        Node node = new Node(val);
        if(start==null) {
            start = node;
            prev = node;
            node.next=start;
        }else{
            start.next = node;
            start=node;
            node.next=prev;
        }

    }

}
