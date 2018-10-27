import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    //Given a collection of distinct integers, return all possible permutations.
    //
    //Example:
    //
    //Input: [1,2,3]
    //Output:
    //[
    //  [1,2,3],
    //  [1,3,2],
    //  [2,1,3],
    //  [2,3,1],
    //  [3,1,2],
    //  [3,2,1]
    //]

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permutation(nums));
        int[] nums2 = new int[]{1,2,3,3};
        System.out.println(permutation2(nums2));


    }
    public static List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, ans, new ArrayList<>());
        return ans;

    }

    public static void backTrack(int[] nums, List<List<Integer>> ans,  List<Integer> tmpList){
        if (tmpList.size() == nums.length){
            ans.add( new ArrayList<>(tmpList));
        }else{
            for (int i =0; i< nums.length; i++){
                if (tmpList.contains(nums[i])){ continue;}
                tmpList.add(nums[i]);
                backTrack(nums, ans, tmpList);
                tmpList.remove(tmpList.size()-1);

            }
        }
    }

    //follow up question
    //if the nums is an array that contains distinct integer
    //Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    //
    //Example:
    //
    //Input: [1,1,2]
    //Output:
    //[
    //  [1,1,2],
    //  [1,2,1],
    //  [2,1,1]
    //]

    public static List<List<Integer>> permutation2(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack2(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    public static void backTrack2(int[] nums, List<List<Integer>> ans, List<Integer> tmpList, boolean[] used){
        if (tmpList.size() == nums.length){
            ans.add(new ArrayList<>(tmpList));
        }else{
            for (int i = 0; i< nums.length; i++){
                if (used[i] || (i>0 && nums[i] == nums[i-1] && !used[i-1])) continue;
                used[i] = true;
                tmpList.add(nums[i]);
                backTrack2(nums, ans, tmpList, used);
                used[i] = false;
                tmpList.remove(tmpList.size()-1);

            }
        }
    }
}
