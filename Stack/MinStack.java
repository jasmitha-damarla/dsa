package Stack;

import java.util.Scanner;
import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack;

    public MinStack() {
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int minVal = minStack.peek();

        while (!minStack.isEmpty()) {
            minVal = Math.min(minVal, minStack.peek());
            tmp.push(minStack.pop());
        }
        
        while (!tmp.isEmpty()) {
            minStack.push(tmp.pop());
        }
        return minVal;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStack minStack = new MinStack();
        
        minStack.push(scanner.nextInt());
        minStack.push(scanner.nextInt());
        minStack.push(scanner.nextInt());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


    }
}
