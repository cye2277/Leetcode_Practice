import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    //Given a binary tree, determine if it is a complete binary tree.
    //
    //Definition of a complete binary tree from Wikipedia:
    //In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
    //
    //
    //
    //Example 1:
    //
    //
    //
    //Input: [1,2,3,4,5,6]
    //Output: true
    //Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
    //Example 2:
    //
    //
    //
    //Input: [1,2,3,4,5,null,7]
    //Output: false
    //Explanation: The node with value 7 isn't as far left as possible.
    //
    //Note:
    //
    //The tree will have between 1 and 100 nodes.

    //Use BFS
    //Time complexity:O(N)
    //Space complexity:O(N)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (queue.peek() != null){
            TreeNode node = queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }

        return queue.isEmpty();
    }
}
