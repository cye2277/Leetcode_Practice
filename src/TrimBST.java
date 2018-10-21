public class TrimBST {

    //Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L).
    //You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.


    public static void main(String[] args) {

    }
    public class TreeNode {
       int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //method1: recursion
    //When we get Node.value < L, the right child tree of the node is the trimmed tree.
    //When we get Node.value > R, the left child tree of the node is the trimmed tree
    //We can trim the tree recursively
    //Time complexity:O(N)
    //Space complexity: O(N)
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null){
            return root;
        }
        if (root.val < L){
            trimBST(root.right, L, R);
        }
        if (root.val > R){
            trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L ,R);
        return root;
    }


}
