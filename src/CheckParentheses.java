public class CheckParentheses {

    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Note that an empty string is also considered valid.
    //
    //Example 1:
    //
    //Input: "()"
    //Output: true
    //Example 2:
    //
    //Input: "()[]{}"
    //Output: true
    //Example 3:
    //
    //Input: "(]"
    //Output: false
    //Example 4:
    //
    //Input: "([)]"
    //Output: false
    //Example 5:
    //
    //Input: "{[]}"
    //Output: true

    public boolean isValid(String s) {
        HashMap<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')','(');
        hashmap.put(']','[');
        hashmap.put('}','{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i< s.length();i++){
            if (hashmap.containsKey(s.charAt(i))){
                if (stack.isEmpty()) return false;
                if (hashmap.get(s.charAt(i)) != stack.pop()){
                    return false;
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
