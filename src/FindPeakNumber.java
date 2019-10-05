public class FindPeakNumber {
    //A peak element is an element that is greater than its neighbors.
    //
    //Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
    //
    //The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
    //
    //You may imagine that nums[-1] = nums[n] = -∞.
    //
    //Example 1:
    //
    //Input: nums = [1,2,3,1]
    //Output: 2
    //Explanation: 3 is a peak element and your function should return the index number 2.
    //Example 2:
    //
    //Input: nums = [1,2,1,3,5,6,4]
    //Output: 1 or 5
    //Explanation: Your function can return either index number 1 where the peak element is 2,
    //             or index number 5 where the peak element is 6.
    //Note:
    //
    //Your solution should be in logarithmic complexity.

    //one pass without space
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    //O(N) for time and space
    public int findPeakElement2(int[] nums) {
        boolean[] right = new boolean[nums.length];
        boolean[] left = new boolean[nums.length];
        int ans = -1;
        left[0] = true;
        for (int i = 1; i< nums.length;i++){
            if (nums[i] > nums[i-1]){
                left[i] = true;
            }else{
                left[i] = false;
            }
        }
        right[nums.length-1] = true;
        for (int i = nums.length-2; i>= 0;i--){
            if (nums[i] > nums[i+1]){
                right[i] = true;
            }else{
                right[i] = false;
            }
        }

        for (int i = 0; i<nums.length;i++){
            if (left[i] && right[i]){
                ans = i;
            }
        }
        return ans;
    }


    //Time complexity:O(Log N)
    //Space complexity:O(Log N)
    public int findPeakElement3(int[] nums) {
        return search(nums, 0, nums.length-1);
    }

    public int search(int[] nums, int l, int r){
        if (l == r) {
            return l;
        }
        int mid = (l+r)/2;
        if (nums[mid] > nums[mid+1]){
            return search(nums, l, mid);
        }
        return search(nums, mid+1, r);
    }
}
