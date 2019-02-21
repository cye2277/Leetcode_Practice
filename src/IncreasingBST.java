import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    //Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
    //
    //Example 1:
    //Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
    //
    //       5
    //      / \
    //    3    6
    //   / \    \
    //  2   4    8
    // /        / \
    //1        7   9
    //
    //Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
    //
    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    //          \
    //           6
    //            \
    //             7
    //              \
    //               8
    //                \
    //                 9


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Time complexity:O(N)
    //Space complexity:O(N)
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        int root_val = vals.get(0);
        TreeNode ans = new TreeNode(root_val), cur = ans;
        for (int i = 1;i<vals.size();i++){
            cur.right = new TreeNode(vals.get(i));
            cur = cur.right;
        }

        return ans;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
}
