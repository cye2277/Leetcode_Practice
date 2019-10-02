import java.util.Arrays;

public class MaximumSwap {


    //Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
    //
    //Example 1:
    //Input: 2736
    //Output: 7236
    //Explanation: Swap the number 2 and the number 7.
    //Example 2:
    //Input: 9973
    //Output: 9973
    //Explanation: No swap.
    //Note:
    //The given number is in the range [0, 108]

    //Brute force
    //Time complexity:O(N*N*N)
    //Sapce complexity: O(N)
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        char[] ans = Arrays.copyOf(A, A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                char tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                for (int k = 0; k < A.length; k++){
                    if (A[k] != ans[k]){
                        if (A[k] > ans[k]) {
                            ans = Arrays.copyOf(A, A.length);
                        }
                        break;
                    }
                }
                A[j] = A[i];
                A[i] = tmp;
            }
        }
        return Integer.valueOf(new String(ans));
    }

    //greedy
    //Time complexity:O(N)
    //Space complexity:O(1)
    public int maximumSwap2(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length;i++){
            last[A[i] - '0'] = i;
        }

        for (int  i =0; i< A.length;i++){
            for (int j = 9; j> A[i]-'0';j--){
                if (last[j] > i){
                    char tmp = A[i];
                    A[i] = A[last[j]];
                    A[last[j]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
