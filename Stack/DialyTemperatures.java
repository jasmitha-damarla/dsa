package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DialyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] sol = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                sol[prev] = i - prev;
            }
            stack.push(i);
        }
        return sol;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] temperatures = new int[n];
        for(int i = 0; i < n; i++){
            temperatures[i] = scanner.nextInt();
        }
        DialyTemperatures dialyTemperatures = new DialyTemperatures();
        // int[] temperatures = {30, 38, 30, 36, 35, 40, 28};
        System.out.println(Arrays.toString(dialyTemperatures.dailyTemperatures(temperatures)));
    }
}
