import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

    //Given two arrays, write a function to compute their intersection.
    //
    //Example 1:
    //
    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2]
    //Example 2:
    //
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [9,4]
    //Note:
    //
    //Each element in the result must be unique.
    //The result can be in any order.

    //Time complexity:O(M+N)
    //Space complexity:O(M+N)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashset1 = new HashSet();
        HashSet<Integer> hashset2 = new HashSet();
        for (int n: nums1){
            hashset1.add(n);
        }
        for (int n: nums2){
            hashset2.add(n);
        }
        if (hashset1.size() >hashset2.size()){
            return getIntersection(hashset1, hashset2);
        }else{
            return getIntersection(hashset2, hashset1);
        }
    }

    public int[] getIntersection(HashSet<Integer> hashset1, HashSet<Integer> hashset2){
        int[] ans = new int[hashset1.size()];
        int index = 0;
        for (Integer i: hashset1){
            if (hashset2.contains(i)){
                ans[index++] = i;
            }
        }
        return Arrays.copyOf(ans,index);
    }
}
