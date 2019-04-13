import java.util.HashMap;

public class FindLDS {
    //We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
    //
    //Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
    //
    //Example 1:
    //Input: [1,3,2,2,5,2,3,7]
    //Output: 5
    //Explanation: The longest harmonious subsequence is [3,2,2,2,3].
    //Note: The length of the input array will not exceed 20,000.

    //Time complexity:O(N)
    //Space complexity:O(N)
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int ans =0;
        for (int i: nums){
            hashmap.put(i,hashmap.getOrDefault(i,0)+1);
            if (hashmap.containsKey(i+1)){
                ans= Math.max(ans, hashmap.get(i+1)+hashmap.get(i));
            }
            if (hashmap.containsKey(i-1)){
                ans = Math.max(ans, hashmap.get(i-1)+ hashmap.get(i));
            }
        }

        return ans;

    }
}
