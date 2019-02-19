import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    //Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
    //
    //For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
    //
    //Two binary trees are considered leaf-similar if their leaf value sequence is the same.
    //
    //Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

    //method 1
    //depth first search recursion
    //T is the length of the tree
    //Time complexity:O(T1+T2)
    //Space complexity:O(T1+T2)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList();
        List<Integer> leaf2 = new ArrayList();
        dfs(root1,leaf1);
        dfs(root2,leaf2);
        return leaf1.equals(leaf2);

    }

    public void dfs(TreeNode node, List<Integer> leafValue){
        if(node != null){
            if(node.left == null && node.right == null){
                leafValue.add(node.val);
            }
            dfs(node.left, leafValue);
            dfs(node.right, leafValue);
        }
    }
}
