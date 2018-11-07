import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT {
    //A full binary tree is a binary tree where each node has exactly 0 or 2 children.
    //
    //Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
    //
    //Each node of each tree in the answer must have node.val = 0.
    //
    //You may return the final list of trees in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: 7
    //Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, List<TreeNode>> meomo = new HashMap<>();

//    public List<TreeNode> allPossibleFBT(int N) {
//        int[] nums = new int[]{1,2,3};
//
//        return;
//    }
}