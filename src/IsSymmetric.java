import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {
    //Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    //
    //For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    //But the following [1,2,2,null,3,null,3] is not:
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    //Note:
    //Bonus points if you could solve it both recursively and iteratively.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //recursive
    //Time complexity:O(N)
    //Space complexity:O(N)

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    //iterative
    //Time complexity:O(N)
    //Sapce complexity:O(N)
    public boolean isSymmetric2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode nodeA = queue.poll();
            TreeNode nodeB = queue.poll();
            if (nodeA == null && nodeB == null) continue;
            if (nodeA == null || nodeB == null) return false;
            if (nodeA.val != nodeB.val) return false;
            queue.add(nodeA.right);
            queue.add(nodeB.left);
            queue.add(nodeA.left);
            queue.add(nodeB.right);
        }
        return true;
    }
}
