import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentNumber {

    //Given a non-empty array of integers, return the k most frequent elements.
    //
    //Example 1:
    //
    //Input: nums = [1,1,1,2,2,3], k = 2
    //Output: [1,2]
    //Example 2:
    //
    //Input: nums = [1], k = 1
    //Output: [1]
    //Note:
    //
    //You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    //Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i =0; i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        while(k>0){
            int maxIndex = 0;
            int max = 0;
            for (int i: hashMap.keySet()){
                if (hashMap.get(i)>max){
                    maxIndex = i;
                    max = hashMap.get(i);
                }
            }
            ans.add(maxIndex);
            hashMap.remove(maxIndex);
            k--;
        }
        return ans;
    }
}
