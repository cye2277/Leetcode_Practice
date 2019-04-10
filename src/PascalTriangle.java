import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
    //In Pascal's triangle, each number is the sum of the two numbers directly above it.
    //
    //Example:
    //
    //Input: 5
    //Output:
    //[
    //     [1],
    //    [1,1],
    //   [1,2,1],
    //  [1,3,3,1],
    // [1,4,6,4,1]
    //]

    //Time complexity:O(N*N)
    //Space complexity:O(N*N)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        if (numRows == 0){
            return ans;
        }
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for (int i = 1; i<numRows; i++){
            List<Integer> subArr = new ArrayList();
            List<Integer> preArr = ans.get(i-1);

            subArr.add(1);

            for (int j = 1; j< i+1;j++){
                if (j<preArr.size()){
                    subArr.add(preArr.get(j-1)+preArr.get(j));
                }else if (j == preArr.size()){
                    subArr.add(preArr.get(j-1));
                }
            }
            ans.add(subArr);
        }
        return ans;

    }

}
