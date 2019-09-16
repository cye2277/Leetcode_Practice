public class ShortestWordString {
    //Total Accepted: 1754 Total Submissions: 4239 Difficulty: Easy
    //Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
    //
    //For example,
    //Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    //
    //Given word1 = “coding”, word2 = “practice”, return 3.
    //Given word1 = "makes", word2 = "coding", return 1.
    //
    //Note:
    //You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


    public int shortestDistance(String[] words, String word1, String word2) {
        int indexOfWord1 = -1;
        int indexOfWord2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length;i++ ){
            if (word1 == words[i]){
                if (indexOfWord1 == -1 && indexOfWord2 != -1){
                    min = i - indexOfWord2;
                }else{
                    min = Math.min(min, i-indexOfWord2);
                }
                indexOfWord1 = i;
            }else if (word2 == words[i]){
                if (indexOfWord1 != -1 && indexOfWord2 == -1){
                    min = i - indexOfWord1;
                }else{
                    min = Math.min(min, i-indexOfWord1);
                }
                indexOfWord2 = i;
            }

        }
        return min;

    }
}