public class FlipEquivalent {

    //For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
    //
    //A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
    //
    //Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.
    //
    //
    //
    //Example 1:
    //
    //Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
    //Output: true
    //Explanation: We flipped at nodes with values 1, 3, and 5.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Time complexity: O(min(N1,N2)) N is length of tree
    //Space complexity: O(min(H1,H2)) H is height of tree
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2){
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val){
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right,root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));

    }
}
