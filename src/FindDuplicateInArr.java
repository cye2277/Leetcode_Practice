import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateInArr {
    //Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    //
    //Find all the elements that appear twice in this array.
    //
    //Could you do it without extra space and in O(n) runtime?
    //
    //Example:
    //Input:
    //[4,3,2,7,8,2,3,1]
    //
    //Output:
    //[2,3]

    //method 1
    //hashset
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i:nums){
            if (hashSet.contains(i)){
                ans.add(i);
            }else{
                hashSet.add(i);
            }
        }
        return ans;
    }
    //method2
    public List<Integer> findDuplicates2(int[] nums){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i< nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if (nums[index]>0){
                nums[index] = -nums[index];
            }else{
                ans.add(index+1);
            }
        }
        return ans;
    }

}
