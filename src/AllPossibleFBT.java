import java.util.HashMap;
import java.util.LinkedList;
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


    Map<Integer, List<TreeNode>> memo = new HashMap();
    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)){
            List<TreeNode> ans = new LinkedList();
            if (N== 1){
                ans.add(new TreeNode(0));
            }else if(N %2 == 1){
                for (int x = 0; x< N;x++){
                    int y = N-1-x;
                    for (TreeNode left: allPossibleFBT(x)){
                        for (TreeNode right: allPossibleFBT(y)){
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            memo.put(N, ans);
        }
        return memo.get(N);
    }
}