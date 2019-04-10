public class IsLongPressedName {
    //Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
    //
    //You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
    //
    //
    //
    //Example 1:
    //
    //Input: name = "alex", typed = "aaleex"
    //Output: true
    //Explanation: 'a' and 'e' in 'alex' were long pressed.
    //Example 2:
    //
    //Input: name = "saeed", typed = "ssaaedd"
    //Output: false
    //Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
    //Example 3:
    //
    //Input: name = "leelee", typed = "lleeelee"
    //Output: true
    //Example 4:
    //
    //Input: name = "laiden", typed = "laiden"
    //Output: true
    //Explanation: It's not necessary to long press any character.
    //
    //
    //Note:
    //
    //name.length <= 1000
    //typed.length <= 1000
    //The characters of name and typed are lowercase letters.
    //



    // two pointer
    // Time complexity:O(M+N)
    // Space complexity:O(1)
    public boolean isLongPressedName(String name, String typed) {
        int j =0;
        for (char c: name.toCharArray()){
            if(j == typed.length()){
                return false;
            }

            if (typed.charAt(j) != c){
                if (j ==0 || typed.charAt(j-1) != typed.charAt(j)){
                    return false;
                }

                char cur = typed.charAt(j);
                while (j< typed.length() && typed.charAt(j) == cur){
                    j++;
                }
                if (j == typed.length() || typed.charAt(j) != c){
                    return false;
                }
            }

            j++;
        }
        return true;

    }

}
