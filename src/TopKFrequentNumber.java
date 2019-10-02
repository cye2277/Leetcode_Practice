import java.util.*;

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


    //PriorityQueue
    //TIME COMPLEXITY:O(N*LOGK)
    //SAPCE COMPLEXITY:O(N)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap  = new HashMap();
        for (int num: nums){
            hashmap.put(num, hashmap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (w1,w2) -> hashmap.get(w1) -hashmap.get(w2)
        );

        for (int num: hashmap.keySet()){
            heap.add(num);
            if (heap.size()>k){
                heap.poll();
            }
        }

        List<Integer> ans = new ArrayList();
        while(!heap.isEmpty()){
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;

    }

    //BUCKET SORT
    public List<Integer> topKFrequent3(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.subList(0,k);
    }
}
