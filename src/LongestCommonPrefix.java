public class LongestCommonPrefix {
    //Write a function to find the longest common prefix string amongst an array of strings.
    //
    //If there is no common prefix, return an empty string "".
    //
    //Example 1:
    //
    //Input: ["flower","flow","flight"]
    //Output: "fl"
    //Example 2:
    //
    //Input: ["dog","racecar","car"]
    //Output: ""
    //Explanation: There is no common prefix among the input strings.
    //Note:
    //
    //All given inputs are in lowercase letters a-z.
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder ans = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String s: strs){
            min = Math.min(s.length(),min);
        }
        int i = 0;
        first: while (i<min){
            for (int j = 1; j< strs.length; j++){
                if (strs[j].charAt(i) != strs[j-1].charAt(i)){
                    break first;
                }
            }
            ans.append(strs[0].charAt(i));
            i++;
        }
        return ans.toString();
    }
}
