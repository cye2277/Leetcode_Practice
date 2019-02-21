import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    //Given a n-ary tree, find its maximum depth.
    //
    //The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //
    //For example, given a 3-ary tree:
    //
    //
    //We should return its max depth, which is 3.

    //BFS

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth1(Node root){
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i<size;i++){
                Node node = queue.poll();
                for (Node child: node.children){
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }

    //DFS
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) { //replace left&right to for loop
            int value = maxDepth2(child);

            if (value > max) {
                max = value;
            }
        }
        return max +1;
    }
}
