package Stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);


        System.out.println("Stack Top : "+ stack.peek());
        System.out.println("Stack Size : "+ stack.size());

        reverseStack(stack);

        System.out.println("Stack Top : "+ stack.peek());
        System.out.println("Stack Size : "+ stack.size());
    }

    private static void reverseStack(Stack<Integer> stack) {

        if(stack.empty())
            return;
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(temp,stack);
    }

    private static void insertAtBottom(int data, Stack<Integer> stack) {
        if(stack.empty()) {
            stack.push(data);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(data,stack);
        stack.push(temp);
    }
}
