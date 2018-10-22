public class NonDecreasingArray {

    //Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
    //We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

    //Example 1:
    //Input: [4,2,3]
    //Output: True
    //Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

    //Example 2:
    //Input: [4,2,1]
    //Output: False
    //Explanation: You can't get a non-decreasing array by modify at most one element.


    //method 1 Brute Force
    //For the given array, if we are changing at most one element A[i], we should change A[i] to A[i-1],
    //Then it would be guaranteed that A[i-1] ≤ A[i], and A[i] would be the smallest possible to try and achieve A[i] ≤ A[i+1].
    //For each possible change A[i], check if the sequence is monotone increasing. We'll modify new, a copy of the array A.
    //Time complexity: O(N*N)
    //Space complexity: O(N)
    public boolean checkPossibility(int[] nums) {

        //check some basic situation
        if (nums.length ==0 ||nums.length ==1){
            return true;
        }

        int[] modifiedArray = nums;
        for (int i = 0; i<nums.length-1;i++){
            int tmp = nums[i];
            if(i ==0){
                modifiedArray[i] = 0;
            }else{
                modifiedArray[i] = modifiedArray[i-1];
            }
            if (monotoneIncreasing(modifiedArray) == true){
                return true;
            }
            modifiedArray[i] = tmp;
        }
        if (modifiedArray[modifiedArray.length-2] > modifiedArray[modifiedArray.length-1]){
            modifiedArray[modifiedArray.length-1] = modifiedArray[modifiedArray.length-2];
            if (monotoneIncreasing(modifiedArray)){
                return true;
            }
        }
        return false;

    }
    // method that check the monotone increasing.
    public boolean monotoneIncreasing(int[] nums){
        for (int i = 0; i<nums.length-1;i++){
            if (nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }

}
