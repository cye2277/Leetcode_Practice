import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    //Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
    //
    //Note:
    //
    //All numbers will be positive integers.
    //The solution set must not contain duplicate combinations.
    //Example 1:
    //
    //Input: k = 3, n = 7
    //Output: [[1,2,4]]
    //Example 2:
    //
    //Input: k = 3, n = 9
    //Output: [[1,2,6], [1,3,5], [2,3,4]]

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,k,n,new ArrayList<>(),1);
        return ans;
    }

    public void helper(List<List<Integer>> ans, int k, int n, List<Integer> tmp, int start){

        if(k == tmp.size() && n==0){
            ans.add(new ArrayList<>(tmp));
        }
        for (int i = start; i<=9;i++){
            tmp.add(i);
            helper(ans, k,n-i,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
