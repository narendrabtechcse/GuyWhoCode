package Stack;

//Array based implementation .
public class StackImplementationArrayFixedSize {

    int[] stack = new int[10];
    int top = -1;
    //int size = 0;

    public void push(int val) throws Exception {
        if(isFull())
        {
            throw new Exception("Stack is Full....!!");
        }else
        {
            stack[++top] = val;
        }
    }

    public void pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is Empty....!!");
        }else {
            --top;
        }
    }

    private boolean isFull()
    {
        if(top==stack.length)
            return true;
        else
            return false;
    }

    private boolean isEmpty()
    {
        if(top==-1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        StackImplementationArrayFixedSize stackImplementation = new StackImplementationArrayFixedSize();
        stackImplementation.push(12);
        stackImplementation.push(14);
        stackImplementation.push(45);
        stackImplementation.push(23);
        stackImplementation.push(87);

        stackImplementation.printStack();

        stackImplementation.pop();
        stackImplementation.pop();

        System.out.println("******************************");
        stackImplementation.printStack();

        stackImplementation.push(22);
        stackImplementation.push(34);
        stackImplementation.push(45);
        stackImplementation.push(83);
        stackImplementation.push(97);

        stackImplementation.push(42);
        stackImplementation.push(14);
        stackImplementation.push(55);


        System.out.println("******************************");
        stackImplementation.printStack();
    }

    public void printStack() {
        for (int i=0;i<=top;i++){
            System.out.println("Values in Stack : " + stack[i]);
        }
    }
}


