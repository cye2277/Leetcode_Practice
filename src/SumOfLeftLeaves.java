import java.util.Stack;

public class SumOfLeftLeaves {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //method 1
    //recursive method
    public int sumOfLeftLeaves1(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null){
                ans += root.left.val;
            }
            else {
                ans += sumOfLeftLeaves1(root.left);
            }
        }
        ans += sumOfLeftLeaves1(root.right);
        return ans;
    }

    //method 2
    //Itarative method
    public int sumOfLeftLeaves2(TreeNode root){
        if (root==null){
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.pop();
            if (node.left != null){
                if (node.left.left == null &&node.left.right == null){
                    ans += node.left.val;
                }else{
                    stack.push(node.left);
                }
            }
            if (node.right != null){
                if (node.right.left != null && node.right.right != null){
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }

}
