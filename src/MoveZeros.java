public class MoveZeros {
    //Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    //
    //Example:
    //
    //Input: [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //Note:
    //
    //You must do this in-place without making a copy of the array.
    //Minimize the total number of operations.
    public static void main(String[] args) {
        int[] test = new int[]{0,1,0,3,12};
        moveZeroes(test);
        for (int i: test){
            System.out.println(i);
        }

    }

    //Time complexity:O(N)
    //Space complexity:O(1)
    public static void moveZeroes(int[] nums) {
        int ptr1 = 0;
        int ptr2 = 1;
        for (int i =0;i<nums.length-1;i++){
            if (nums[ptr1] == 0 && nums[ptr2] != 0) {
                int tmp = nums[ptr1];
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = tmp;
                ptr1++;
            }else if(nums[ptr1] != 0 && nums[ptr2] == 0 ){
                ptr1++;
            }else if (nums[ptr1] == 0 && nums[ptr2] == 0){
            }else if (nums[ptr1] != 0 && nums[ptr2] != 0){
                ptr1++;
            }
            ptr2++;
        }
    }

}
