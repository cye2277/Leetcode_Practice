import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindClosestElements {
    //Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
    //
    //Example 1:
    //Input: [1,2,3,4,5], k=4, x=3
    //Output: [1,2,3,4]
    //Example 2:
    //Input: [1,2,3,4,5], k=4, x=-1
    //Output: [1,2,3,4]


    public static void main(String[] args) {
        List<Integer> testArr = new ArrayList<>();
        testArr.add(1);
        testArr.add(2);
        testArr.add(3);
        testArr.add(4);
        testArr.add(5);
        testArr.add(6);
        testArr.add(7);
        testArr.add(8);
        testArr.add(9);
        testArr.add(10);
        List<Integer> ans = findClosestElements2(testArr, 5, 9);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    //method1
    //Using collection.sort()
    //We can sort the array by the order of distance from the x, then we just take the first k element from this array
    //Time complexity: sort use binary sort, so the complexity is O(n*log(n))
    //Space complexity: we initiate the new subarray, lenghth is k, so complexity is O(k).
    public static List<Integer> findClosestElements1(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }


    //method2
    //using binary search and two pointer
    //There are three situation about this problem.
    //1.If the x is less than or equal to the first element get the first k elements
    //2.if the x is larger than or equal to the last element, get the last k elements.
    //3.Otherwise, we can use the binary search find index of element, which is equal to or a little larger than x, then set low to its k-1 left index, set high to its k-1 right. The desired index range can be [index-k+1, index+k-1]
    //We can shrink this range to get the result using the following rules.
    //-If low reaches the lowest index 0 or the low element is closer to x than the high element, decrease the high index.
    //-If high reaches to the highest index arr.size()-1 or it is nearer to x than the low element, increase the low index.
    //-The looping ends when there are exactly k elements in [low, high], the subList of which is the result.
    //Time complexity:O(logn+k),O(logn)is binary search, k is shrinking the range to k elements.
    //Space complexity:O(k)
    public static List<Integer> findClosestElements2(List<Integer> arr, int k, int x) {
        int n = arr.size();
        if (x <= arr.get(0)){
            return arr.subList(0,k);
        }else if (x >= arr.get(n-1)){
            return arr.subList(n-k,n);
        }else{
            int index = Collections.binarySearch(arr,x);
            if (index<0){
                index = -index-1;
            }
            int low = Math.max(0,index-k-1);
            int high = Math.min(n-1,index+k-1);

            while (high-low>k-1){
                if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
                    high--;
                else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return arr.subList(low, high + 1);

        }
    }
}
