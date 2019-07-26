public class LowestCommonAncestor {
    //Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    //
    //According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    //
    //Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
    //
    //
    //
    //
    //Example 1:
    //
    //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //Output: 6
    //Explanation: The LCA of nodes 2 and 8 is 6.
    //Example 2:
    //
    //Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    //Output: 2
    //Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
    //
    //
    //Note:
    //
    //All of the nodes' values will be unique.
    //p and q are different and both values will exist in the BST.

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    //recursive
    //time complexity:O(N)
    //Space complexity:O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pvalue = p.val;
        int qvalue = q.val;
        int parentValue = root.val;

        if (pvalue> parentValue && qvalue > parentValue){
            return lowestCommonAncestor(root.right,p,q);
        }else if (pvalue < parentValue && qvalue < parentValue){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }


    //iterative method
    //time complexity:O(N)
    //space complexity:O(1)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pvalue= p.val;
        int qvalue = q.val;
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pvalue > parentVal && qvalue > parentVal) {
                node = node.right;
            } else if (pvalue < parentVal && qvalue < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
