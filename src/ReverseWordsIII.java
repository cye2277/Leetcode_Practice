import java.util.ArrayList;
import java.util.List;

public class ReverseWordsIII {
    //Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
    //
    //Example 1:
    //Input: "Let's take LeetCode contest"
    //Output: "s'teL ekat edoCteeL tsetnoc"
    //Note: In the string, each word is separated by single space and there will not be any extra space in the string.

    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (String words: s.split(" ")){
            StringBuilder newWord = new StringBuilder(words);
            ans.append(newWord.reverse().toString()+ " ");
        }
        String sentence = ans.toString().trim();
        return sentence;
    }

}
