package Queue;

class QArrayBasedImpl
{
    int front,rear;
    int size;
    int capacity;
    int[] queue;

    public QArrayBasedImpl(int capacity)
    {
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    void enQueue(int data)
    {
        if(capacity==rear)
        {
            System.out.println("Queue is full");
            return;
        }else{
            queue[rear] = data;
            rear++;
        }
    }

    void deQueue()
    {
        if(front==rear)
        {
            System.out.println("Queue is Empty !!");
            return;
        }else{
            for(int i=0;i<rear-1;i++)
            {
                queue[i] = queue[i+1];
            }

            if(rear<capacity)
            {
                queue[rear] = 0;
            }

            rear--;
        }
        return;
    }

    void queueDisplay()
    {
        if(front==rear) {
            System.out.println("Queue is Empty");
            return;
        }

        for(int i=front;i<rear;i++)
        {
            System.out.printf(" %d <-- ", queue[i]);
        }
          return;
    }

    // print front of queue
    void queueFront()
    {
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element is: %d", queue[front]);
        return;
    }


}

public class StaticQinJava {

    public static void main(String[] args) {

        // Create a queue of capacity 4
        QArrayBasedImpl q = new QArrayBasedImpl(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.enQueue(20);
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.enQueue(60);

        // print Queue elements
        q.queueDisplay();

        q.deQueue();
        q.deQueue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}
