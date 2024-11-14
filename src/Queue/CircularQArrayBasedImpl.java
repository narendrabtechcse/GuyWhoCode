package Queue;

public class CircularQArrayBasedImpl {

    public int maxSize;
    public int front;
    public int rear;
    public int[] queueArray;

    public CircularQArrayBasedImpl(int size)
    {
        maxSize = size;
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //method to enqueue (add) an item to the circular queue
    public void enQueue(int item)
    {
        if(isEmpty())
        {
            front = 0;
            rear = 0;
            queueArray[rear] = item;
        }else{
            //Circular increment of rear index
            rear = (rear+1)%maxSize;
            if(rear==front)
            {
                System.out.println("Queue is full. Cannot enqueue.");

                //Reset rear to its previous value
                rear = (rear-1 + maxSize) % maxSize;
            }
            else {
                queueArray[rear] = item;
            }
        }
    }

    public int dequeue()
    {
        int item = -1;
        if(!isEmpty())
        {
            item = queueArray[front];
            if(front==rear)
            {
                //Reset front and read to -1 to indicate an empty queue
                front = -1;
                rear = -1;
            }
            else{
                //Circular increment of front index
                front = (front+1) % maxSize;
            }
        }
        else {
            System.out.println("Queue is empty. Cannot dequeue !!");
        }
        return item;
    }

    //Method to peek at the front element of the circular queue without removing it.
    public int peek()
    {
        if(!isEmpty())
        {
            return queueArray[front];
        }
        else {
            System.out.println("Queue is Empty. No Peek Value");
            return -1;
        }
    }

    public boolean isEmpty()
    {
        return front == -1 && rear == -1;
    }

    //Main method for testing the CircularQueue class
    public static void main(String[] args)
    {
        CircularQArrayBasedImpl circularQArrayBased = new CircularQArrayBasedImpl(3);

        circularQArrayBased.enQueue(1);
        circularQArrayBased.enQueue(2);
        circularQArrayBased.enQueue(3);
        circularQArrayBased.enQueue(4);

        // Should print 1
        System.out.println("Peek: " + circularQArrayBased.peek());

        // Should print 1
        System.out.println("Dequeue: " + circularQArrayBased.dequeue());

        // Should print 2
        System.out.println("Peek after dequeue: " + circularQArrayBased.peek());

        // Should print 2
        System.out.println("Dequeue: " + circularQArrayBased.dequeue());

        // Should print 3
        System.out.println("Dequeue: " + circularQArrayBased.dequeue());

        // Should print empty
        System.out.println("Dequeue: " + circularQArrayBased.dequeue());
    }
}
