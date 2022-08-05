package StandardJavaInterviewWriteCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class PC {

    List<Integer> list = new ArrayList<Integer>();
    int capacity = 2;

    public void produce() throws InterruptedException {

        int value = 0;

        while(true)
        {
            synchronized (this)
            {

                if(list.size()==capacity)
                    wait();

                System.out.println("Producer produced-"
                        + value);

                list.add(value++);

                notify();

                Thread.sleep(1000);

            }
        }
    }

    public void consume() throws InterruptedException {

        while (true)
        {
            synchronized (this)
            {
                if(list.size()==0)
                    wait();

                int val = list.remove(0);

                System.out.println("Consumer consumed-"
                        + val);

                notify();

                Thread.sleep(1000);
            }
        }
    }
}
