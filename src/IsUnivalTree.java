import java.util.Stack;

public class IsUnivalTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //method 1
    //iterative method
    //time complexity:O(N)
    //space complexity:O(H)
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack  = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode n = stack.pop();
            if (n.left != null && n.left.val != n.val){
                return false;

            }else if (n.left != null && n.left.val == n.val){
                stack.push(n.left);
            }

            if (n.right != null && n.right.val != n.val){
                return false;

            }else if (n.right != null && n.right.val == n.val){
                stack.push(n.right);
            }
        }
        return true;
    }

    //method 2
    //recursion
    //Time complexity:O(N)
    //Space complexity:O(H)
    public boolean isUnivalTree2(TreeNode root) {
        boolean left_correct = (root.left == null ||(root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||(root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }


}
