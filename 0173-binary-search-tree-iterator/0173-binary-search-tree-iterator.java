/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    
    Stack<TreeNode> st = new Stack<>();

    public void fillStack(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        fillStack(root);
    }
    
    public int next() {
        TreeNode root = st.pop();
        if(root.right != null){
            fillStack(root.right);
        }
        return root.val;
    }
    
    public boolean hasNext() {
        if(st.size()==0) return false;

        return true; 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */