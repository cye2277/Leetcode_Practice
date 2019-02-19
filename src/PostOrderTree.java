import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTree {

    //Given an n-ary tree, return the postorder traversal of its nodes' values.
    //
    //For example, given a 3-ary tree:
    //
    //
    //
    //
    //
    //
    //
    //Return its postorder traversal as: [5,6,3,2,4,1]


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    //method 1
    //recursion
    //Time complexity:O(L)
    //Space complexity:O(L)
    public List<Integer> postOrder(Node root) {
        List<Integer> ans = new ArrayList();
        dfs(root, ans);
        return ans;
    }
    public void dfs(Node node, List<Integer> ans){
        if (node!= null){
            for (Node n: node.children){
                dfs(n,ans);
            }
            ans.add(node.val);
        }

    }

    //method 2
    //iteration
    //Time complexity:O(L)
    //Space complexity:O(L)
    public List<Integer> postOrder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root  == null){
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            root = stack.pop();
            ans.add(root.val);
            for (Node node:root.children){
                stack.add(node);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

}
