import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumBinaryTree {
    //Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
    //
    //Example 1:
    //Input:e
    //    5
    //   / \
    //  3   6
    // / \   \
    //2   4   7
    //
    //Target = 9
    //
    //Output: True
    //Example 2:
    //Input:
    //    5
    //   / \
    //  3   6
    // / \   \
    //2   4   7
    //
    //Target = 28
    //
    //Output: False

    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static boolean findTarget(TreeNode node,int target){
        if (node == null){
            return false;
        }
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode n = queue.remove();
            if (set.contains(target-n.val)){
                return true;
            }
            set.add(n);
            if (n.left!= null){
                queue.add(n.left);
            }
            if (n.right!= null){
                queue.add(n.right);
            }
        }
        return false;

    }


}
