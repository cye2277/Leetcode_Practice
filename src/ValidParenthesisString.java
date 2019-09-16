public class ValidParenthesisString {
    //Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
    //
    //Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    //Any right parenthesis ')' must have a corresponding left parenthesis '('.
    //Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    //'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
    //An empty string is also valid.


    //dynamic programming

    //counting
    public boolean checkValidString(String s) {
        int min_op = 0;
        int max_op = 0;
        for (char c: s.toCharArray()){
            if (c == '('){
                min_op++;
            }else{
                if (min_op > 0){
                    min_op--;
                }
            }
            if ((c == '*') || (c == '(')){
                max_op++;
            }else{
                max_op--;
                if (max_op<0){
                    return false;
                }
            }
        }
        if (min_op != 0){
            return false;
        }
        return true;
    }

}
