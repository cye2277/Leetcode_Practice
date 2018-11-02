import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // method 1
    //recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        helper(root, ans);
        return ans;
    }
    public void helper(TreeNode root, List<Integer> ans){
        ans.add(root.val);
        if(root.left != null){
            helper(root.left,ans);
        }
        if(root.right != null){
            helper(root.right,ans);
        }
    }
    //method 2
    //iterative
    public List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null){
            while (curr!= null){
                ans.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return ans;
    }
}
