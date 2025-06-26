package Stack;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> parenthesesStack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                parenthesesStack.push(ch);
                continue;
            }
            else if(ch == ')'){
                if(!parenthesesStack.empty() && parenthesesStack.peek() == '(') {
                    parenthesesStack.pop();
                    continue;
                }
            }
            else if(ch == ']'){
                if(!parenthesesStack.empty() && parenthesesStack.peek() == '[') {
                    parenthesesStack.pop();
                    continue;
                }
            }
            else if(ch == '}'){
                if(!parenthesesStack.empty() && parenthesesStack.peek() == '{') {
                    parenthesesStack.pop();
                    continue;
                }
            }
            parenthesesStack.push(ch);
        }
        return parenthesesStack.isEmpty();
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(str)? "Yes":"No");

    }
}
