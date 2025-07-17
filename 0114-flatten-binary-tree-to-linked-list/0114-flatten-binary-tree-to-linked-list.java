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

class Solution {
    public TreeNode last(TreeNode root){
        
        while(true){
            if(root.right == null && root.left == null) break;

            if(root.right !=null ){
                root = root.right;
            }
            else if(root.left != null){
                root = root.left;
            }
        }
        return root;
    }

    public void flatten(TreeNode root) {

        while(root!=null){
            if(root.left!=null){
                TreeNode t = last(root.left);
                if(root.right !=null)
                t.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

}