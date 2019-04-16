public class ValidPalindrome {
    //Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
    //
    //Example 1:
    //Input: "aba"
    //Output: True
    //Example 2:
    //Input: "abca"
    //Output: True
    //Explanation: You could delete the character 'c'.
    //Note:
    //The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

    //Time complexity:O(N*N)
    //Space complexity:O(N)
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i< s.length(); i++){
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if (isPalindrome(sb.toString())){
                return true;
            }
            sb.insert(i,c);
        }
        return isPalindrome(s);

    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<= j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }


    //Time complexity:O(N)
    //Space complexity:O(N)
    public boolean validPalindrome1(String s) {
        for (int i = 0; i< s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                int j = s.length()-i-1;
                return (isPalindrome1(s,i+1,j) || isPalindrome1(s, i,j-1));
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s, int i , int j){
        while (i<= j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
