import java.util.HashMap;

public class TwoSum {

    //Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //Example:
    //
    //Given nums = [2, 7, 11, 15], target = 9,
    //
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i< nums.length;i++){
            if (hashmap.containsKey(nums[i]) ){
                ans[0] = hashmap.get(nums[i]);
                ans[1] = i;
            }
            hashmap.put(target-nums[i],i);

        }

        return ans;
    }
}
