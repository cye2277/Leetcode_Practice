import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    //Given a set of distinct integers, nums, return all possible subsets (the power set).
    //
    //Note: The solution set must not contain duplicate subsets.
    //
    //Example:
    //
    //Input: nums = [1,2,3]
    //Output:
    //[
    //  [3],
    //  [1],
    //  [2],
    //  [1,2,3],
    //  [1,3],
    //  [2,3],
    //  [1,2],
    //  []
    //]

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        System.out.println(subset(nums));
        int[] nums2 = new int[]{1,2,3,3};
        System.out.println(subset2(nums2));


    }

    public static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(ans, new ArrayList<>(), nums,0);
        return ans;
    }

    public static void backTrack(List<List<Integer>> list, List<Integer> tmpList, int[] nums, int start){
        list.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++  ){
            tmpList.add(nums[i]);
            backTrack(list, tmpList, nums, i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }

    //follow up question
    //if it is a array that contains duplicate integer, how to solve this problem
    public static List<List<Integer>> subset2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack2(ans, new ArrayList<>(), nums,0);
        return ans;
    }

    public static void backTrack2(List<List<Integer>> list, List<Integer> tmpList, int[] nums, int start){
        list.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++  ){
            if (i> start && nums[i] == nums[i-1]){
                continue;
            }else{
                tmpList.add(nums[i]);
                backTrack2(list, tmpList, nums, i+1);
                tmpList.remove(tmpList.size()-1);

            }
        }
    }


}
