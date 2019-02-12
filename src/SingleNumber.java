import java.util.Arrays;
import java.util.HashSet;

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


    public int[] singleNumber1(int[] nums) {
        int[] ans = new int[2];
        if(nums == null || nums.length <=1){
            return ans;
        }

        HashSet<Integer> record = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(record.contains(nums[i])){
                record.remove(nums[i]);
            }
            else{
                record.add(nums[i]);
            }
        }
        Object[] test = record.toArray();
        ans[0]=(int)test[0];
        ans[1]=(int)test[1];
        return ans;
    }
    public int[] singleNumber2(int[] nums) {
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
