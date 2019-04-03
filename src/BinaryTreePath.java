import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    //Given a binary tree, return all root-to-leaf paths.
    //
    //Note: A leaf is a node with no children.
    //
    //Example:
    //
    //Input:
    //
    //   1
    // /   \
    //2     3
    // \
    //  5
    //
    //Output: ["1->2->5", "1->3"]
    //
    //Explanation: All root-to-leaf paths are: 1->2->5, 1->3

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePath(TreeNode root){
        List<String> ans = new ArrayList<>();
        if (root != null) searchBT(root,"", ans);
        return ans;
    }
    public void searchBT(TreeNode node, String s, List<String> ans){
        if (node.left == null && node.right == null){
            ans.add(s + node.val);
        }

        if (node.left != null){
            searchBT(node.left, s + node.val+"->",ans);
        }
        if (node.right != null){
            searchBT(node.right, s + node.val+"->",ans);
        }
    }

}
