import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    //Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    //
    //You may assume that the array is non-empty and the majority element always exist in the array.
    //
    //Example 1:
    //
    //Input: [3,2,3]
    //Output: 3
    //Example 2:
    //
    //Input: [2,2,1,1,1,2,2]
    //Output: 2

    public static void main(String[] args) {

    }

    //method1
    //Hashtable
    //Time comoplexity:O(N)
    //Space Complexity:O(N)
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        int majority = -1;
        for (int num : nums){
            if (hashmap.containsKey(num)){
                hashmap.put(num,hashmap.get(num)+1);
            }else{
                hashmap.put(num,1);
            }
            if (hashmap.get(num)>nums.length/2){
                majority = num;
            }
        }
        return majority;

    }

    //method2
    //Sorting
    //time complexity:O(NlogN)
    //Space complexity:O(1)

    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        int ans = nums[nums.length/2];
        return ans;
    }

}
