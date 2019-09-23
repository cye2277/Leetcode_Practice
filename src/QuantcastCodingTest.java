
class Solution {
    public static void main(String[] args) {
        char[] input = {'c', 'o', 'd', 'i', 'n', 'g', ' ', 'i', 's', ' ', 'f', 'u', 'n'};
        reverseCharArr(input);
        for (char character : input) {
            System.out.println(character);
        }
    }

    public static char[] reverseCharArr(char[] charArr) {
        reverse(charArr, 0, charArr.length - 1);
        int start = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                reverse(charArr, start, i - 1);
                start = i + 1;
            } else if (i == charArr.length - 1) {
                reverse(charArr, start, i);
            }
        }
        return charArr;
    }

    public static void reverse(char[] charArr, int start, int end) {
        while (start < end) {
            char tmp;
            tmp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = tmp;
            start++;
            end--;
        }
    }

}