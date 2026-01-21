package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public void getParenthesis(int n, int o, int c, List<String> res, String cur) {
        if (o + c == 2 * n) {
            String str = cur.toString();
            res.add(str);
        }
        if (o < n) {
            getParenthesis(n, o + 1, c, res, cur + "(");
        }
        if (c < o) {
            getParenthesis(n, o, c + 1, res, cur + ")");
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<>();
        getParenthesis(n, 0, 0, sol, "");
        return sol;
    }

    public static void main(String[] args) {
        GenerateParanthesis generateParanthesis = new GenerateParanthesis();
        System.out.println(generateParanthesis.generateParenthesis(5));
    }

}