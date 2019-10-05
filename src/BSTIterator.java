import java.util.ArrayList;

public class BSTIterator {
    //Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
    //
    //Calling next() will return the next smallest number in the BST.
    //
    //
    //
    //Example:
    //
    //
    //
    //BSTIterator iterator = new BSTIterator(root);
    //iterator.next();    // return 3
    //iterator.next();    // return 7
    //iterator.hasNext(); // return true
    //iterator.next();    // return 9
    //iterator.hasNext(); // return true
    //iterator.next();    // return 15
    //iterator.hasNext(); // return true
    //iterator.next();    // return 20
    //iterator.hasNext(); // return false
    //
    //
    //Note:
    //
    //next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    //You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<Integer> arraylist;
    int index;
    public BSTIterator(TreeNode root){
        this.arraylist = new ArrayList();
        index = -1;
        this._inorder(root);

    }



    public void _inorder(TreeNode root){
        if (root == null){
            return;
        }
        _inorder(root.left);
        this.arraylist.add(root.val);
        _inorder(root.right);
    }
    /** @return the next smallest number */
    public int next() {
        return this.arraylist.get(++this.index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index+1 < this.arraylist.size();
    }
}
