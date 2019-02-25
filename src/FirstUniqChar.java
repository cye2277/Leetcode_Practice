public class FirstUniqChar {

    //Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
    //
    //Examples:
    //
    //s = "leetcode"
    //return 0.
    //
    //s = "loveleetcode",
    //return 2.
    //Note: You may assume the string contain only lowercase letters.


    //Time complexity:O(L) length of s
    //Space complexity:O(1)
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        int index = -1;
        for (char c: s.toCharArray()){
            letters[c-'a'] += 1;
        }
        for (int i = 0; i< s.length();i++){
            if (letters[s.charAt(i)-'a'] == 1){
                index = i;
                break;
            }
        }
        return index;
    }
}
