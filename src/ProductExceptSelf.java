public class ProductExceptSelf {
    //Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
    //
    //Example:
    //
    //Input:  [1,2,3,4]
    //Output: [24,12,8,6]
    //Note: Please solve it without division and in O(n).
    //
    //Follow up:
    //Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


    //no division and time complexity:O(N)
    //Space compelxity:O(N)
    public int[] productExceptSelf1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right= new int[nums.length];
        left[0] = 1;
        for (int i = 1; i< nums.length;i++){
            left[i] = left[i-1] *nums[i-1];
        }
        right[nums.length-1] = 1;
        for (int i = nums.length-2; i>=0;i--){
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i< nums.length;i++){
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    //Space complexity:O(1)
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }

}
