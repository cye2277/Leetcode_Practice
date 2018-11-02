import java.util.ArrayList;
import java.util.HashMap;

public class MagicDictionary {
    //mplement a magic directory with buildDict, and search methods.
    //
    //For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
    //
    //For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.
    //
    //Example 1:
    //Input: buildDict(["hello", "leetcode"]), Output: Null
    //Input: search("hello"), Output: False
    //Input: search("hhllo"), Output: True
    //Input: search("hell"), Output: False
    //Input: search("leetcoded"), Output: False
    //Note:
    //You may assume that all the inputs are consist of lowercase letters a-z.
    //For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
    //Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.


    HashMap<Integer, ArrayList<String>> hashMap;
    public MagicDictionary(){
        hashMap = new HashMap<>();
    }

    public void buildDict(String[] dict) {
        for (String word: dict){
            if (!hashMap.containsKey(word.length())){
                hashMap.put(word.length(),new ArrayList<>());
            }
            hashMap.get(word.length()).add(word);
        }
    }

    public boolean search(String word){
        if (hashMap.containsKey(word.length())) return false;
        for (String s:hashMap.get(word.length())){
            int misMatch = 0;
            for (int i = 0;i<word.length(); i++){
                if ( word.charAt(i) != s.charAt(i)){
                    misMatch++;
                    if (misMatch>1) break;
                }
            }
            if (misMatch == 1) return true;
        }
        return false;


    }
}
