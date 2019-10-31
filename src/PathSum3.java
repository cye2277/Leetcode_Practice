public class PathSum3 {
       public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int pathSumFrom(TreeNode node, int rest){
        if (node == null){
            return 0;
        }
        return (node.val == rest? 1:0) + pathSumFrom(node.left, rest-node.val) + pathSumFrom(node.right, rest -node.val);
    }
}
