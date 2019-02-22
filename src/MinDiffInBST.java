import java.util.TreeSet;

public class MinDiffInBST {
    //Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
    //
    //Example:
    //
    //Input:
    //
    //   1
    //    \
    //     3
    //    /
    //   2
    //
    //Output:
    //1
    //
    //Explanation:
    //The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    //method 1
    //in-order traverse
    //Time complexity O(N)
    //Space complexity O(1)
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int minDiffInBST(TreeNode root){
        if (root == null){
            return min;
        }
        minDiffInBST(root.left);
        if (prev!= null){
            min = Math.min(min,root.val-prev);
        }
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }

    //Follow-up
    //if it is not a binary tree
    //We can use the treeset, and then in preorder to go through each node
    //Time complexity:O(NlognN) treeset use logN to find the nearest number in the treeset
    //Space complexity: O(N)
    TreeSet<Integer> set = new TreeSet<>();
    int min2 = Integer.MIN_VALUE;
    public int minDiffInBST1(TreeNode root){
        if (root == null){
            return min2;
        }
        if(!set.isEmpty()){
            if (set.floor(root.val) != null){
                min2 = Math.min(min2, root.val-set.floor(root.val));
            }
            if (set.ceiling(root.val)!= null){
                min2 = Math.min(min2, set.ceiling(root.val) - root.val);
            }

        }
        set.add(root.val);
        minDiffInBST1(root.left);
        minDiffInBST1(root.right);
        return  min2;
    }
}
