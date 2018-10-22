import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    //Given two binary trees, write a function to check if they are the same or not.
    //Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    //Example 1:
    //
    //Input:     1         1
    //          / \       / \
    //         2   3     2   3
    //
    //        [1,2,3],   [1,2,3]
    //
    //Output: true

    //Example 2:
    //
    //Input:     1         1
    //          /           \
    //         2             2
    //
    //        [1,2],     [1,null,2]
    //
    //Output: false
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //method 1
    //recursion
    public boolean isSameTree(TreeNode rootA, TreeNode rootB){
        if (rootA == null && rootB == null){
            return true;
        }
        if (rootA == null || rootB == null){
            return false;
        }
        if (rootA.val == rootB.val){
            return isSameTree(rootA.left, rootB.left) && isSameTree(rootA.right, rootB.right);
        }
        return false;
    }

    //method
    //iteration
    public  boolean isSameTree2(TreeNode rootA, TreeNode rootB){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootA);
        queue.add(rootB);
        while (!queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if (f == null && s == null){
                continue;
            }
            if (f == null || s == null || f.val != s.val){
                return false;
            }
            queue.add(rootA.left);
            queue.add(rootB.left);
            queue.add(rootA.right);
            queue.add(rootB.right);
        }
        return true;
    }

}
