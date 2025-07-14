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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int ls = 1+ height(root.left);
        int rs = 1+ height(root.right);

        return ls > rs ? ls : rs ;
    }

    
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int ls = height(root.left);
        int rs = height(root.right);
        System.out.println(ls+" "+rs);
        
        if(ls == rs){
            return (1 << ls)  + countNodes(root.right);
        }
        else
            return 1 +  (int)Math.pow(2,rs) - 1 + countNodes(root.left);
    }
}
