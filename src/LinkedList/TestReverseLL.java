package LinkedList;

public class TestReverseLL {

    public static void main(String[] args) {
        NodeLL head;

        NodeLL node1 = new NodeLL(1);

        head = node1;

        NodeLL node2 = new NodeLL(2);
        node1.next = node2;

        NodeLL node3 = new NodeLL(3);
        node2.next = node3;

        NodeLL node4 = new NodeLL(4);
        node3.next = node4;

        NodeLL node5 = new NodeLL(5);
        node4.next = node5;

        reverseLL(head);

    }

    private static NodeLL reverseLL(NodeLL head) {
        NodeLL curr = null, prev = null;

        while (head != null) {
            curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }

        return prev;
    }

}

class NodeLL {
    int val;
    NodeLL next;

    NodeLL(int val) {
        this.val = val;
    }
}
