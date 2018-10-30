import java.util.Stack;

public class NextGreaterElement {
    //Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
    //
    //Example 1:
    //Input: [1,2,1]
    //Output: [2,-1,2]
    //Explanation: The first 1's next greater number is 2;
    //The number 2 can't find next greater number;
    //The second 1's next greater number needs to search circularly, which is also 2.
    //Note: The length of given array won't exceed 10000.


    //method1
    //use double length array
    //time complexity:O(N*N)
    //space complexity:O(N)
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int[] doublenums = new int[nums.length * 2];
        System.arraycopy(nums, 0, doublenums, 0, nums.length);
        System.arraycopy(nums, 0, doublenums, nums.length, nums.length);
        for (int i = 0; i < nums.length; i++) {
            res[i]=-1;
            for (int j = i + 1; j < doublenums.length; j++) {
                if (doublenums[j] > doublenums[i]) {
                    res[i] = doublenums[j];
                    break;
                }
            }
        }
        return res;
    }
    //method2
    //Brute force
    //time complexity:O(N*N)
    //space complexity:O(N)
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i<n;i++){
            ans[i] = -1;
            for (int j = 1;j<n;j++){
                if(nums[(i+j)%n]>nums[i]){
                    ans[i] = nums[(i+j)%n];
                    break;
                }
            }
        }
        return ans;
    }

    //method 3
    //using stack
    //time complexity:O(N)
    //space complexity:O(N)
    public int[] nextGreaterElements3(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 2*n-1; i>=0;i--){
            while (!stack.empty() && nums[stack.peek()]<= nums[i%n] ){
                stack.pop();
            }
            ans[i%n] = stack.empty() ? -1: nums[stack.peek()];
            stack.push(i%n);
        }
        return ans;
    }
}
