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

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int ls = maxDepth(root.left);
        int rs = maxDepth(root.right);

        return 1 + Math.max(ls, rs);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int diameter = maxDepth(root.left)+maxDepth(root.right);
        
        int left_dia = diameterOfBinaryTree(root.left);
        int right_dia = diameterOfBinaryTree(root.right);

        return Math.max(diameter,Math.max(left_dia,right_dia));
    }
}