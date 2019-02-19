import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTree {

    //Given an n-ary tree, return the preorder traversal of its nodes' values.
    //
    //For example, given a 3-ary tree:
    //
    //
    //
    //
    //
    //
    //
    //Return its preorder traversal as: [1,3,5,6,2,4].

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //method 1
    //recursion
    //Time complexity:O(L)
    //Space complexity:O(L)
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList();
        dfs(root, ans);
        return ans;
    }
    public void dfs(Node node, List<Integer> ans){
        if (node!= null){
            ans.add(node.val);
            for (Node n: node.children){
                dfs(n,ans);
            }
        }

    }


    //METHOD 2
    //iteratioN
    //Time complexity:O(L)
    //Space complexity:O(L)
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root  == null){
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            root = stack.pop();
            ans.add(root.val);
            for (int i = root.children.size()-1;i>=0;i--){
                stack.add(root.children.get(i));
            }
        }
        return ans;


    }
}
