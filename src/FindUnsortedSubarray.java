import java.util.Arrays;
import java.util.Stack;

public class FindUnsortedSubarray {


    //Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
    //
    //You need to find the shortest such subarray and output its length.
    //
    //Example 1:
    //Input: [2, 6, 4, 8, 10, 9, 15]
    //Output: 5
    //Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
    //Note:
    //Then length of the input array is in range [1, 10,000].
    //The input array may contain duplicates, so ascending order here means <=.

    //Sorting make it O(NLONGN)
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    // Using Stack to implement O(N)
    public int findUnsortedSubarray2(int[] nums) {
        Stack< Integer > stack = new Stack <Integer>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    // Without space
    public int findUnsortedSubarray3(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i< nums.length;i++){
            if (nums[i] <nums[i-1]){
                flag = true;
            }
            if (flag == true){
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length-2; i>= 0;i--){
            if (nums[i] > nums[i+1]){
                flag = true;
            }
            if (flag){
                max = Math.max(max, nums[i]);
            }
        }
        int l, r;
        for (l = 0; l < nums.length; l++){
            if (min< nums[l]){
                break;
            }
        }
        for (r = nums.length -1; r >= 0 ; r--){
            if (max> nums[r]){
                break;
            }
        }
        return r-l < 0 ? 0 : r-l+1;
    }
}
