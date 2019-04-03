import java.util.Arrays;
import java.util.HashMap;

public class FindErrorNums {
    //The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
    //
    //Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
    //
    //Example 1:
    //Input: nums = [1,2,2,4]
    //Output: [2,3]
    //Note:
    //The given array size will in the range [2, 10000].
    //The given array's numbers won't have any order.

    //Brute force
    //TIme complexity:O(N*N)
    //Space complexity:O(1)
    public static int[] findErrorNums(int[] nums){
        int duplicate = -1;
        int missing = -1;
        for (int i = 1; i<= nums.length;i++){
            int count = 0;
            for (int j = 0; j<nums.length;j++){
                if (nums[j] == i){
                    count++;
                }
                if (count == 2){
                    duplicate = i;
                }
                if (count == 0){
                    missing = i;
                }
                if (duplicate >0 && missing >0){
                    break;
                }
            }
        }
        return new int[]{duplicate,missing};
    }

    //Sorting
    //Time complexity:O(NlogN)
    //Space complexity:O(logN)
    public static int[] findErrorNums2(int[] nums){
        Arrays.sort(nums);
        int dup= -1, missing =-1;
        for (int i = 1;i< nums.length;i++){
            if (nums[i]== nums[i-1]){
                dup = nums[i];
            }else if (nums[i]>nums[i-1]+1){
                missing = nums[i-1]+1;
            }
        }
        return new int[]{dup, nums[nums.length-1] != nums.length? nums.length:missing};
    }

    //Map
    //Time complexity:O(N)
    //Space complexity:O(N)
    public static int[] fidnErrorNums(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int dup = -1;
        int missing = -1;
        for (int n: nums){
            hashMap.put(n,hashMap.getOrDefault(n,0)+1);
        }
        for (int i =1; i<= nums.length;i++){
            if (hashMap.containsKey(i)){
                if (hashMap.get(i)== 2){
                    dup = i;
                }
            }else{
                missing = i;
            }
        }
        return new int[]{dup,missing};
    }






}
