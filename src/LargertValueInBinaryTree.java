import java.util.ArrayList;
import java.util.List;

public class LargertValueInBinaryTree {
    //You need to find the largest value in each row of a binary tree.
    //
    //Example:
    //Input:
    //
    //          1
    //         / \
    //        3   2
    //       / \   \
    //      5   3   9
    //
    //Output: [1, 3, 9]
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(root, ans, 0);
        return ans;
    }
    public void helper(TreeNode node,List<Integer> ans,int depth){
        if (node == null){
            return;
        }

        if (ans.size() == depth){
            ans.add(node.val);
        }else{
            ans.set(depth, Math.max(ans.get(depth),node.val));
        }
        helper(node.left,ans,depth+1);
        helper(node.right,ans,depth+1);
    }
}
