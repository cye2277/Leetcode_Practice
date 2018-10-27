import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    //Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
    //
    //The same repeated number may be chosen from candidates unlimited number of times.
    //
    //Note:
    //
    //All numbers (including target) will be positive integers.
    //The solution set must not contain duplicate combinations.
    //Example 1:
    //
    //Input: candidates = [2,3,6,7], target = 7,
    //A solution set is:
    //[
    //  [7],
    //  [2,2,3]
    //]
    //Example 2:
    //
    //Input: candidates = [2,3,5], target = 8,
    //A solution set is:
    //[
    //  [2,2,2,2],
    //  [2,3,3],
    //  [3,5]
    //]

    public static void main(String[] args){
        int[] nums =  new int[]{2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(nums, target));
        nums =  new int[]{2,3,5};
        target = 8;
        System.out.println(combinationSum(nums, target));


        //test case for follow up question

        nums =  new int[]{10,1,2,7,6,1,5};
        target = 8;
        System.out.println(combinationSum2(nums, target));
        nums =  new int[]{2,5,2,1,2};
        target = 5;
        System.out.println(combinationSum2(nums, target));

    }

    public static List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack( nums,  target,  ans, new ArrayList<>(), 0 );
        return ans;

    }

    public static void backTrack(int[] nums, int remain, List<List<Integer>> ans, List<Integer> tmpList, int start){

        if (remain == 0){
            ans.add(new ArrayList<>(tmpList));
        }else if (remain <0){
            return;
        }
        else{
            for (int i = start; i<nums.length;i++){
                tmpList.add(nums[i]);
                remain -= nums[i];
                backTrack(nums, remain, ans, tmpList,i);
                tmpList.remove(tmpList.size()-1);
                remain += nums[i];
            }
        }
    }


    //follow up question
    //if the number can not be used twice, but we can allow duplicate integer input
    //Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
    //
    //Each number in candidates may only be used once in the combination.
    //
    //Note:
    //
    //All numbers (including target) will be positive integers.
    //The solution set must not contain duplicate combinations.
    //Example 1:
    //
    //Input: candidates = [10,1,2,7,6,1,5], target = 8,
    //A solution set is:
    //[
    //  [1, 7],
    //  [1, 2, 5],
    //  [2, 6],
    //  [1, 1, 6]
    //]
    //Example 2:
    //
    //Input: candidates = [2,5,2,1,2], target = 5,
    //A solution set is:
    //[
    //  [1,2,2],
    //  [5]
    //]

    public static List<List<Integer>> combinationSum2(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack2( nums,  target,  ans, new ArrayList<>(), 0 );
        return ans;

    }

    public static void backTrack2(int[] nums, int remain, List<List<Integer>> ans, List<Integer> tmpList, int start){

        if (remain == 0){
            ans.add(new ArrayList<>(tmpList));
        }else if (remain <0){
            return;
        }
        else{
            for (int i = start; i<nums.length;i++){
                if(i>start && nums[i] == nums[i-1] ) continue; // skip duplicates
                tmpList.add(nums[i]);
                remain -= nums[i];
                backTrack2(nums, remain, ans, tmpList,i+1);
                tmpList.remove(tmpList.size()-1);
                remain += nums[i];
            }
        }
    }



}
