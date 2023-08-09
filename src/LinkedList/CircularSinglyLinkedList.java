package LinkedList;

public class CircularSinglyLinkedList {

    public NodeCLL head;
    public NodeCLL tail;
    public int size;

    public NodeCLL createCSLL(int nodeValue)
    {
        head = new NodeCLL();
        NodeCLL nodeCLL = new NodeCLL();
        nodeCLL.value = nodeValue;
        nodeCLL.next = nodeCLL;
        head = nodeCLL;
        tail = nodeCLL;
        size = 1;
        return  head;
    }

    //Insertion Method
    public void insertCSLL(int nodeValue,int location)
    {
        NodeCLL nodeCLL = new NodeCLL();
        nodeCLL.value = nodeValue;

        if(head==null)
        {
            createCSLL(nodeValue);
            return;
        }else if(location==0)
        {
            nodeCLL.next = head;
            head = nodeCLL;
            tail.next = head;
        }else if(location >= size)
        {
            tail.next = nodeCLL;
            tail = nodeCLL;
            tail.next = head;
        }else{
            NodeCLL tempNode = head;
            int index = 0;
            while(index<location-1)
            {
                tempNode = tempNode.next;
                index++;
            }
            nodeCLL.next = tempNode.next;
            tempNode.next=nodeCLL;
        }
        size++;
    }

    //traversal method
    public void traverseCSLL()
    {
        if(head!=null) {
            NodeCLL tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println("\n");
        }else{
            System.out.println("\n CSLL does not exist !!");
        }
    }

    //Search Method
    public boolean searchNode(int nodeValue)
    {
        if(head!=null)
        {
            NodeCLL tempNode = head;
            for(int i=0;i<size;i++)
            {
                if(tempNode.value==nodeValue)
                {
                    System.out.println("Found node at location : "+i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found !!");
        return false;
    }

    //delete Method
    public void deleteNode(int location)
    {
        if(head==null)
        {
            System.out.println("The CSLL does not exist !!");
            return;
        }else if(location==0)
        {
            head = head.next;
            tail.next = head;
            size--;
            if(size == 0)
            {
                tail = null;
                head.next = null;
                head = null;
            }
        }else if(location >= size)
        {
            NodeCLL tempNode = head;
            for(int i=0;i<size-1;i++)
            {
                tempNode = tempNode.next;
            }
            if(tempNode == head)
            {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next=head;
            tail=tempNode;
            size--;
        } else{
            NodeCLL tempNode = head;
            for(int i=0;i<location-1;i++)
            {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    //Delete CSLL
    public void deleteCSLL()
    {
        if(head==null)
        {
            System.out.println("The CSLL does not exist !!");
        }else{
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The CSLL has been deleted !!");
        }
    }

}

class NodeCLL{
    public int value;
    public NodeCLL next;
}

class Main1
{
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCSLL(5);
        csll.insertCSLL(4,0);
        csll.insertCSLL(6,1);
        csll.insertCSLL(7,8);
        csll.traverseCSLL();
        csll.deleteCSLL();
        csll.traverseCSLL();
    }
}
