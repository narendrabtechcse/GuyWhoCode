package Queue;

public class QueueArrayBasedImpl {

    int front , rear , size;
    int capacity;
    int[] queue;

    //constructor for creating queue
    public QueueArrayBasedImpl(int capacity)
    {
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    // function to insert an element
    // at the rear of the queue
     void queueEnqueue(int data){
        if(capacity == rear){
            System.out.println("Queue is full !!");
            return;
        }else{
            queue[rear] = data;
            rear++;
        }
    }

    // function to delete an element
    // from the front of the queue
    void queueDequeue()
    {
        if(front==rear){
            System.out.println("Queue is Empty !!");
            return;
        }else{
            for (int i=0;i<rear-1;i++)
            {
                queue[i] = queue[i+1];
            }

            if(rear<capacity)
                queue[rear] = 0;

            rear--;
        }
        return;
    }

    // print queue elements
     void queueDisplay()
    {
        int i;
        if (front == rear) {
            System.out.printf("\nQueue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
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

 class StaticQueueinjava {

    // Driver code
    public static void main(String[] args)
    {
        // Create a queue of capacity 4
        QueueArrayBasedImpl q = new QueueArrayBasedImpl(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(20);
        q.queueEnqueue(30);
        q.queueEnqueue(40);
        q.queueEnqueue(50);

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}
