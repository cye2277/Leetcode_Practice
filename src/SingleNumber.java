import java.util.Arrays;

public class SingleNumber {
    //Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
    //
    //Example:
    //
    //Input:  [1,2,1,3,2,5]
    //Output: [3,5]
    //Note:
    //
    //The order of the result is not important. So in the above example, [5, 3] is also correct.

    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        Arrays.sort(nums);
        int start = 0;
        int i = 0;
        while (start<n){
            if (start != n-1){
                if (nums[start] != nums[start+1]){
                    ans[i] = nums[start];
                    i++;
                    start++;
                }
                else{
                    start = start + 2;
                }
            }else{
                ans[i] = nums[start];
            }
        }
        return ans;

    }
}
