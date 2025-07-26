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
    
    TreeNode root = null;

    public TreeNode rightMost(TreeNode node){
        TreeNode temp = node;

        while (temp.right != null && temp.right != root) {
            temp = temp.right;
        }
        
        return temp;
    }
    public BSTIterator(TreeNode node) {
        root = node;
    }
    
    public int next() {
        int ans = 0;
        while(root.left != null){
            TreeNode temp = rightMost(root.left);
            if(temp.right == root){
                temp.right = null;
                break;
            }
            else{
                temp.right = root;
            }
            root = root.left;
        }
        ans = root.val;
        root = root.right;
        return ans;
    }
    
    public boolean hasNext() {
        if(root != null) return true;
        else return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */