public class SortArrayByParity {
    //Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
    //
    //Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
    //
    //You may return any answer array that satisfies this condition.
    //
    //
    //
    //Example 1:
    //
    //Input: [4,2,5,7]
    //Output: [4,5,2,7]
    //Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
    //
    //
    //Note:
    //
    //2 <= A.length <= 20000
    //A.length % 2 == 0
    //0 <= A[i] <= 1000

    //method 1
    //two pass
    //Time complexity:O(N)
    //Space Complexity:O(N)
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i< A.length; i+=2 ){

            if (A[i] % 2 == 1){
                while (A[j]%2 == 1){
                    j += 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;

            }
        }

        return A;
    }

    //method2
    //read and write
    //Time complexity:O(N)
    //Space Complexity:O(1)
    public int[] sortArrayByParityII2(int[] A) {
        int a = 1;
        for (int i = 0; i< A.length; i+=2 ){
            while (a%2 == 0){
                a += 2;
            }
            if (A[i] % 2 == 1){
                int tmp = A[i];
                A[i] = A[a];
                A[a] = tmp;

            }
        }

        return A;
    }
}
