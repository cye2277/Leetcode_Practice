public class BalancedBinaryTree {
    //Given a binary tree, determine if it is height-balanced.
    //
    //For this problem, a height-balanced binary tree is defined as:
    //
    //a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    //
    //Example 1:
    //
    //Given the following tree [3,9,20,null,null,15,7]:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //Return true.
    //
    //Example 2:
    //
    //Given the following tree [1,2,2,3,3,null,null,4,4]:
    //
    //       1
    //      / \
    //     2   2
    //    / \
    //   3   3
    //  / \
    // 4   4
    //Return false.

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return (Math.abs(height(root.left) - height(root.right)) < 2) && isBalanced(root.right) && isBalanced(root.left);
    }

    public Integer height(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.right)+1,height(root.left)+1);
    }
}
