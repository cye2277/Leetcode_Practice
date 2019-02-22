import java.util.HashMap;

public class TwoSum2 {
    //Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
    //
    //The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    //
    //Note:
    //
    //Your returned answers (both index1 and index2) are not zero-based.
    //You may assume that each input would have exactly one solution and you may not use the same element twice.
    //Example:
    //
    //Input: numbers = [2,7,11,15], target = 9
    //Output: [1,2]
    //Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

    //TWO LOOP
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i = 0; i<numbers.length;i++){
            for (int j = i+1; j < numbers.length;j++){
                if (numbers[i]+ numbers[j] == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                }
            }
        }
        return ans;
    }

    //HASHMAP
    public int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for (int i = 0; i<numbers.length;i++){
            if (hashmap.containsKey(numbers[i])){
                ans = new int[]{hashmap.get(numbers[i])+1,i+1};
            }
            hashmap.put(target-numbers[i],i);
        }
        return ans;
    }

    //TWO POINTER
    public int[] twoSum3(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }


}
