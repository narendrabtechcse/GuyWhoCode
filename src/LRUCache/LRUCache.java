package LRUCache;

import java.util.HashMap;

class Node
{
    int value;
    Node prev,next = null;

    Node(int value)
    {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache {

    private final int capacity;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();

        //initialList
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(int key , int value)
    {

        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            addToFront(node);
        }else{
            if(map.size() == capacity)
            {
                Node node = map.get(tail.prev);
                map.remove(node.value);
                remove(node);
            }
            //create a new node
            Node newNode = new Node(value);
            map.put(value,newNode);
            addToFront(newNode);
        }
    }

    int get(int key)
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key); //getting the address from the map
            remove(node);
            addToFront(node);
            return node.value;

        }
        else
        {
            return -1; //key not found
        }
    }

    private void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev= node.prev;
    }

    private void addToFront(Node node)
    {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
