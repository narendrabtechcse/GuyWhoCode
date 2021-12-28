package Queue;

import java.util.ArrayList;

public class CircularQueue2 {

    int front , rear , size ;
    // Declaring array list of integer type.
    private ArrayList<Integer> queue = new ArrayList<Integer>();

    CircularQueue2(int size){
        this.front = this.rear = -1;
        this.size = size;
    }

    public void enque(int data)
    {
        if(!isFull())
        {
            if(isEmpty()){
                queue.add(rear, data);
            }else{

            }
        }
    }

    public boolean isFull()
    {
        // Condition if queue is full.
        if((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1)))
        {
            System.out.print("Queue is Full");
        }

        return true;
    }

    public boolean isEmpty()
    {
        // condition for empty queue.
       if(front == -1)
    {
        front = 0;
        rear = 0;
       return true;
    }else
        return false;

    }
}
