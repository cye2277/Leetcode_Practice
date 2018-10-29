import java.util.HashSet;
import java.util.Stack;

public class ConstructTreeToString {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    //Method 1
    //recursion

    public static String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null){
            return t.val+"";
        }
        if (t.right == null){
            return t.val+"("+tree2str(t.left)+")";
        }
        return t.val+"(" +tree2str(t.left)+")("+tree2str(t.right)+")";
    }

    //Method2
    //iteration

    public static String tree2str2(TreeNode t){
        if (t == null){return ""}
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        stack.push(t);

        while (!stack.empty()){
            TreeNode node = stack.peek();
            if (visited.contains(node)){
                stack.pop();
                ans.append(")");
            }else{
                visited.add(node);
                ans.append("("+node.val);

                if (node.left == null && node.right!= null){
                    ans.append("()");
                }
                if (node.right != null){
                    stack.push(t.right);
                }
                if (node.left != null){
                    stack.push(t.left)
                }
            }

        }
         return ans.substring(1, ans.length() - 1);;

    }



}
