import java.util.Stack;

public class ScoreOfParentheses {

    //Given a balanced parentheses string S, compute the score of the string based on the following rule:
    //
    //() has score 1
    //AB has score A + B, where A and B are balanced parentheses strings.
    //(A) has score 2 * A, where A is a balanced parentheses string.
    //
    //
    //Example 1:
    //
    //Input: "()"
    //Output: 1
    //Example 2:
    //
    //Input: "(())"
    //Output: 2
    //Example 3:
    //
    //Input: "()()"
    //Output: 2
    //Example 4:
    //
    //Input: "(()(()))"
    //Output: 6
    //
    //
    //Note:
    //
    //S is a balanced parentheses string, containing only ( and ).
    //2 <= S.length <= 50

    public int scoreOfParentheses(String S) {
        return F(S, 0, S.length());
    }

    //method1
    //recursive
    public int F(String S, int i, int j) {
        //Score of balanced string S[i:j]
        int ans = 0, bal = 0;

        // Split string into primitives
        for (int k = i; k < j; ++k) {
            bal += S.charAt(k) == '(' ? 1 : -1;
            if (bal == 0) {
                if (k - i == 1) ans++;
                else ans += 2 * F(S, i+1, k);
                i = k+1;
            }
        }

        return ans;
    }

    //method2
    //stack
    public int scoreOfParentheses2(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
