public class BstFromPreorder {
    //Return the root node of a binary search tree that matches the given preorder traversal.
    //
    //(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
    //
    //
    //
    //Example 1:
    //
    //Input: [8,5,1,7,10,12]
    //Output: [8,5,10,1,7,null,12]
    //
    //
    //
    //Note:
    //
    //1 <= preorder.length <= 100
    //The values of preorder are distinct.


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound){
        if (bound == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A,root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }



}
