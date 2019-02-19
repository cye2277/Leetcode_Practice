public class ShortestToChar {
    //Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
    //
    //Example 1:
    //
    //Input: S = "loveleetcode", C = 'e'
    //Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
    //
    //
    //Note:
    //
    //S string length is in [1, 10000].
    //C is a single character, and guaranteed to be in string S.
    //All letters in S and C are lowercase.

    //Time complexity:O(N)
    //Space complexity:O(N)
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        int prev = Integer.MIN_VALUE/2;

        for (int i = 0; i< S.length(); i++){
            if (C == S.charAt(i)){
                prev = i;
            }
            ans[i] = i-prev;
        }

        prev = Integer.MAX_VALUE/2;
        for (int i = S.length()-1; i>=0;i--){
            if (C == S.charAt(i)){
                prev = i;
            }
            ans[i] = Math.min(prev-i,ans[i]);
        }
        return ans;
    }
}
