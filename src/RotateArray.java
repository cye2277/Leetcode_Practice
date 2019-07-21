public class RotateArray {

    //Given an array, rotate the array to the right by k steps, where k is non-negative.
    //
    //Example 1:
    //
    //Input: [1,2,3,4,5,6,7] and k = 3
    //Output: [5,6,7,1,2,3,4]
    //Explanation:
    //rotate 1 steps to the right: [7,1,2,3,4,5,6]
    //rotate 2 steps to the right: [6,7,1,2,3,4,5]
    //rotate 3 steps to the right: [5,6,7,1,2,3,4]
    //Example 2:
    //
    //Input: [-1,-100,3,99] and k = 2
    //Output: [3,99,-1,-100]
    //Explanation:
    //rotate 1 steps to the right: [99,-1,-100,3]
    //rotate 2 steps to the right: [3,99,-1,-100]
    //Note:
    //
    //Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    //Could you do it in-place with O(1) extra space?


    //Brute force
    //time complexity:O(N*K)
    //space complexity:O(1)
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    //Use extra array
    //Time complexity:O(N)
    //Space complexity:O(1)
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    //Cyclic Replacements
    //time complexity:O(N)
    //Space complexity:O(1)
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
}
