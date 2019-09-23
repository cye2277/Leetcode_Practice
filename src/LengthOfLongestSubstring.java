import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    //Given a string, find the length of the longest substring without repeating characters.
    //
    //Example 1:
    //
    //Input: "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    //Example 2:
    //
    //Input: "bbbbb"
    //Output: 1
    //Explanation: The answer is "b", with the length of 1.
    //Example 3:
    //
    //Input: "pwwkew"
    //Output: 3
    //Explanation: The answer is "wke", with the length of 3.
    //             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


    //brute force
    //Time complexity:O(N*N*N)
    //Space complexity: O(min(n,m))
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
        if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    //Slide Windows
    //Time Complexity:O(N)
    //Space Complexity:O(N)
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
