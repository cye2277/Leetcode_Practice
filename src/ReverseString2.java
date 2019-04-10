public class ReverseString2 {
    //Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
    //Example:
    //Input: s = "abcdefg", k = 2
    //Output: "bacdfeg"
    //Restrictions:
    //The string consists of lower English letters only.
    //Length of the given string and k will in the range [1, 10000]


    //Time complexity: O(N)
    //Space complexity:O(N)
    public static String ReverseString(String str, int k){
        char[] charArr = str.toCharArray();
        for (int start = 0; start < str.length(); start += 2*k){
            int i = start;
            int j = Math.min(start + k -1,str.length()-1);
            while (i<j ){
                char tmp = charArr[j];
                charArr[j--] = charArr[i];
                charArr[i++] = tmp;
            }
        }
        return new String(charArr);
    }
}
