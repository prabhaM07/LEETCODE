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
    boolean flag = true;

    void dfs(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return;
        }
        if(root1 == null || root2 == null || root1.val != root2.val){
            flag = false;
            return ;
        }
        dfs(root1.left,root2.right);
        dfs(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        dfs(root.left,root.right);
        return flag;
    }
}