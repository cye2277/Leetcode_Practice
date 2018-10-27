import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    //Given an array of integers, find if the array contains any duplicates.
    //
    //Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
    //
    //Example 1:
    //
    //Input: [1,2,3,1]
    //Output: true
    //Example 2:
    //
    //Input: [1,2,3,4]
    //Output: false
    //Example 3:
    //
    //Input: [1,1,1,3,3,4,3,2,4,2]
    //Output: true


    public static void main(String[] args) {

    }

    //method 1
    //naive linear search
    //time complexity:O(N*N)
    //space complexity:O(1)

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }

    //method 2
    //Sorting
    //time complexity:  O(nlogn)
    //space complexity: O(1)
    public static boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i<nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                return  true;
            }
        }
        return false;
    }

    //method 3
    //Hashtable
    //Time complexity: O(N)
    //Space complexity: O(N)
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x:nums){
            if (set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }

    //
}
