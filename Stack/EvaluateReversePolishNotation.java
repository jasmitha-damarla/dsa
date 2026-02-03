package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str: tokens) {
            if(str.equals("+")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(b+a);
            } else if(str.equals("*")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(b*a);
            } else if(str.equals("-")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(b-a);
            } else if(str.equals("/")) {
                Integer a = stack.pop();
                Integer b = stack.pop();
                stack.push(b/a);
            } else { 
                Integer i = Integer.valueOf(str);
                stack.push(i);
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String[] tokens = {"1", "2", "+", "3", "*","4","-"};
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens));
    }
    
}
