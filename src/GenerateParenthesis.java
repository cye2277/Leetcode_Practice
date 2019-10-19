import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    //
    //For example, given n = 3, a solution set is:
    //
    //[
    //  "((()))",
    //  "(()())",
    //  "(())()",
    //  "()(())",
    //  "()()()"
    //]

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max *2){
            ans.add(cur);
            return;
        }
        if (open < max){
            backtrack(ans, cur+"(", open+1, close, max);
        }
        if (close < open){
            backtrack(ans, cur+ ")", open, close +1, max);
        }
    }
}
