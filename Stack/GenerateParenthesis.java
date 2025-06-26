package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParenthesis {

    public void getParenthesis(int n, int o, int c, List<String> res, String cur){
        if(o + c == 2*n) {
            res.add(cur);
        }
        if(o < n) {
            getParenthesis(n, o + 1, c, res, cur + "(");
        }  
        if(c < o) {
            getParenthesis(n, o, c + 1, res, cur + ")");
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<>();
        getParenthesis(n, 0, 0, sol, "");
        return sol;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        Scanner scanner = new Scanner(System.in);
        generateParenthesis.generateParenthesis(scanner.nextInt()).forEach(System.out::println);
    }
    
}
