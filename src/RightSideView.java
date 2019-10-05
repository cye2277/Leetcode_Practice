public class RightSideView {

    //Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
    //
    //Example:
    //
    //Input: [1,2,3,null,5,null,4]
    //Output: [1, 3, 4]
    //Explanation:
    //
    //   1            <---
    // /   \
    //2     3         <---
    // \     \
    //  5     4       <---

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer,Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodestack = new Stack<TreeNode>();
        Stack<Integer> depthstack = new Stack<Integer>();

        nodestack.push(root);
        depthstack.push(0);
        while (!nodestack.isEmpty()){
            TreeNode node = nodestack.pop();
            int depth = depthstack.pop();
            if (node!= null){
                max_depth = Math.max(max_depth, depth);
                if (!hashmap.containsKey(depth)){
                    hashmap.put(depth,node.val);
                }
                nodestack.push(node.left);
                nodestack.push(node.right);
                depthstack.push(depth+1);
                depthstack.push(depth+1);
            }
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i<= max_depth;i++){
            ans.add(hashmap.get(i));
        }
        return ans;
    }

}
