import java.util.HashMap;

public class HouseRobberIII {
    //The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
    //
    //Determine the maximum amount of money the thief can rob tonight without alerting the police.
    //
    //Example 1:
    //
    //Input: [3,2,3,null,3,null,1]
    //
    //     3
    //    / \
    //   2   3
    //    \   \
    //     3   1
    //
    //Output: 7
    //Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    //Example 2:
    //
    //Input: [3,4,5,1,3,null,1]
    //
    //     3
    //    / \
    //   4   5
    //  / \   \
    // 1   3   1
    //
    //Output: 9
    //Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.


    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    // METHOD 1
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    //METHOD 2
    public int rob2(TreeNode root){
        return robHelper(root, new HashMap<TreeNode, Integer>());
    }
    public int robHelper(TreeNode root, HashMap<TreeNode, Integer> map) {

        if (root == null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        int val = 0;
        if (root.left != null){
            val += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }
        if (root.right != null){
            val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }
        val = Math.max(root.val + val, robHelper(root.left, map) + robHelper(root.right, map));
        map.put(root, val);

        return val;
    }

    //METHOD 3
    public int rob3(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
