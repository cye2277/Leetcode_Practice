import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    //Given a string s, partition s such that every substring of the partition is a palindrome.
    //
    //Return all possible palindrome partitioning of s.
    //
    //Example:
    //
    //Input: "aab"
    //Output:
    //[
    //  ["aa","b"],
    //  ["a","a","b"]
    //]

    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
        s = "aaab";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        backTrack(ans, new ArrayList<>(),s, 0);
        return ans;
    }

    public static void backTrack(List<List<String>> ans, List<String> tmpList,String s, int start){
        if (start == s.length()){
            ans.add(new ArrayList<String>(tmpList));
        }else{
            for (int i = start; i< s.length(); i++){
                if (isPalindrome(s,start,i)){
                    tmpList.add(s.substring(start, i+1));
                    backTrack(ans, tmpList,s,i+1);
                    tmpList.remove(tmpList.size()-1);
                }
            }
        }

    }

    public static boolean isPalindrome(String s, int low, int high){
        while (low< high){
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

}
