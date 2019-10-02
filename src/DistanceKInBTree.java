import java.util.*;

public class DistanceKInBTree {
    //We are given a binary tree (with root node root), a target node, and an integer value K.
    //
    //Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
    //
    //Output: [7,4,1]
    //
    //Explanation:
    //The nodes that are a distance 2 from the target node (with value 5)
    //have values 7, 4, and 1.
    //
    //
    //
    //Note that the inputs "root" and "target" are actually TreeNodes.
    //The descriptions of the inputs above are just serializations of these objects.
    //
    //
    //Note:
    //
    //The given tree is non-empty.
    //Each node in the tree has unique values 0 <= node.val <= 500.
    //The target node is a node in the tree.
    //0 <= K <= 1000.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //Annotate Parent
    //Time complexity:O(N)
    //Space complexity:O(N)
    Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                if (dist == K){
                    ArrayList<Integer> ans = new ArrayList();
                    for (TreeNode n : queue){
                        ans.add(n.val);
                    }
                    return ans;
                }
                dist++;
                queue.offer(null);
            }else{
                if (!seen.contains(node.left)){
                    queue.add(node.left);
                    seen.add(node.left);
                }
                if (!seen.contains(node.right)){
                    queue.add(node.right);
                    seen.add(node.right);
                }
                TreeNode par =  parent.get(node);
                if (!seen.contains(par)){
                    queue.add(par);
                    seen.add(par);
                }
            }

        }
        return new ArrayList();

    }

    public void dfs(TreeNode node, TreeNode par){
        if (node != null){
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
