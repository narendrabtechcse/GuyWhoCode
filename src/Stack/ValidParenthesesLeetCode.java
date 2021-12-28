package Stack;
import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 */

public class ValidParenthesesLeetCode {

    public boolean isValid(String s) {

        Stack stack = new Stack();

        for(int i=0;i<s.length();i++)
        {
            if(stack.empty()){
                if( s.charAt(i) == ']' || s.charAt(i)==')' || s.charAt(i)=='}')
                    return false;
            }
            if( s.charAt(i) == '(' || s.charAt(i)=='[' || s.charAt(i)=='{')
            {
                stack.push(s.charAt(i));
            }else if(
                    ( s.charAt(i)==')' && !((char)stack.peek() == '(' ) )||
                            ( s.charAt(i)=='}' && !((char)stack.peek()=='{') ) ||
                            (s.charAt(i)==']' && !((char)stack.peek()=='[')))
            {
                return false;
            }
            else{
                stack.pop();
                }
        }
        if(!stack.empty())
            return false;

        return true;
    }
}