public class DetactCapital {
    //Given a word, you need to judge whether the usage of capitals in it is right or not.
    //
    //We define the usage of capitals in a word to be right when one of the following cases holds:
    //
    //All letters in this word are capitals, like "USA".
    //All letters in this word are not capitals, like "leetcode".
    //Only the first letter in this word is capital if it has more than one letter, like "Google".
    //Otherwise, we define that this word doesn't use capitals in a right way.
    //Example 1:
    //Input: "USA"
    //Output: True
    //Example 2:
    //Input: "FlaG"
    //Output: False
    //Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
    public static void main(String[] args) {
        String word = "FlAg";
        System.out.println(detectCapitalUse(word));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() ==1 ||word.length() == 0){
            return true;
        }
        if (word.charAt(0)-'a'<0){
            if (word.charAt(1)-'a'<0){
                for (int i = 2;i<word.length();i++){
                    if (word.charAt(i)-'a'>=0){
                        return false;
                    }
                }
            }else{
                for (int i = 2;i<word.length();i++){
                    if (word.charAt(i)-'a'<0){
                        return false;
                    }else{
                        continue;
                    }
                }
            }
        }else{
            for (char c: word.toCharArray()){
                if (c-'a'>=0){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;

    }

}
