import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(checkForPaliDrome("abccba"));
        System.out.println(checkForPaliDrome("I did, did I?"));
        System.out.println(checkForPaliDrome("hello"));
        System.out.println(checkForPaliDrome("Don't nod"));

    }
    public static boolean checkForPaliDrome(String string){
        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder stringNoPuncuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();
        for (int i = 0; i<lowerCase.length();i++){
            char c =lowerCase.charAt(i);
            if (c>'a' && c<'z'){
                stack.push(c);
                stringNoPuncuation.append(c);
            }
        }
        StringBuilder reverseString = new StringBuilder(stack.size());
        while (!stack.isEmpty()){
            reverseString.append(stack.pop());
        }

        return stringNoPuncuation.toString().equals(reverseString.toString());

    }


    public static boolean checkForPalidrome1(String string){
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCaseString = string.toLowerCase();

        for (int i = 0; i < string.length();i++){
            char c = string.charAt(i);
            if (c>'a' && c<'z'){
                stack.push(c);
                queue.add(c);
            }
        }
        while (!stack.isEmpty()){
            if (!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }
        return true;
    }
}
