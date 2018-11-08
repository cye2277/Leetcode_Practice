import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordFromSentence {
    //We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
    //
    //A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
    //
    //Return a list of all uncommon words.
    //
    //You may return the list in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: A = "this apple is sweet", B = "this apple is sour"
    //Output: ["sweet","sour"]
    //Example 2:
    //
    //Input: A = "apple apple", B = "banana"
    //Output: ["banana"]

    //time complexity:O(M+N) M is A's length, N is B's length
    //space complexity: O(M+N)
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        List<String> ans = new ArrayList<>();

        for (String s: count.keySet()){
            if(count.get(s) ==1){
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
