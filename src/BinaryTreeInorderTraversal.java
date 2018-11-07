import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //method 1
    //recursion
    //time complexity:O(N)
    //space complexity:O(N)

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        helper(root,ans);
        return ans;
    }
    public void helper(TreeNode root, List<Integer> ans){
        if (root.left != null){
            helper(root.left, ans);
        }
        ans.add(root.val);
        if (root.right   != null){
            helper(root.right, ans);
        }
    }

    //method2
    //iterative method
    //time complexity:O(N)
    //space complexit:O(N)
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null){
            while (curr.left != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;

        }
        return ans;
    }
}
