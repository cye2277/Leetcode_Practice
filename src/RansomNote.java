public class RansomNote {
    //Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
    //
    //Each letter in the magazine string can only be used once in your ransom note.
    //
    //Note:
    //You may assume that both strings contain only lowercase letters.
    //
    //canConstruct("a", "b") -> false
    //canConstruct("aa", "ab") -> false
    //canConstruct("aa", "aab") -> true

    //Time complexity: O(N)
    //Space complexity: O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (char c: magazine.toCharArray()){
            letters[c-'a'] += 1;
        }
        for (char c: ransomNote.toCharArray()){
            if (letters[c-'a'] == 0){
                return false;
            }else{
                letters[c-'a'] -= 1;
            }
        }
        return true;
    }

}
