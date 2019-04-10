import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdToArrForm {

    //For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].
    //
    //Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
    //
    //
    //
    //Example 1:
    //
    //Input: A = [1,2,0,0], K = 34
    //Output: [1,2,3,4]
    //Explanation: 1200 + 34 = 1234
    //Example 2:
    //
    //Input: A = [2,7,4], K = 181
    //Output: [4,5,5]
    //Explanation: 274 + 181 = 455
    //Example 3:
    //
    //Input: A = [2,1,5], K = 806
    //Output: [1,0,2,1]
    //Explanation: 215 + 806 = 1021
    //Example 4:
    //
    //Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
    //Output: [1,0,0,0,0,0,0,0,0,0,0]
    //Explanation: 9999999999 + 1 = 10000000000
    //
    //
    //Note：
    //
    //1 <= A.length <= 10000
    //0 <= A[i] <= 9
    //0 <= K <= 10000
    //If A.length > 1, then A[0] != 0

    public static void main(String[] args) {
        int[] inArr = new int[]{9,9,9,9,9,9,9,9,9,9};
        int K = 1;
        System.out.println(addToArrayForm(inArr,K));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    //This method will give wrong answer is given number are too big
    public static List<Integer> addToArrayForm2(int[] A, int K) {
        long number = 0;
        for (int i = 0; i< A.length;i++){
            number += Math.pow(10,A.length-1-i)*A[i];
        }
        System.out.println(number);
        number += K;
        System.out.println(number);
        List<Integer> ans = new ArrayList<>();
        String s = Long.toString(number);
        for (int i = 0; i< s.length();i++){
            ans.add(s.charAt(i)-'0');
        }
        return ans;
    }
}
