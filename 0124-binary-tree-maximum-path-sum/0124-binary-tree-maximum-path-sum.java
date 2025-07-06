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
    int maxi = Integer.MIN_VALUE;

    public int maxSum(TreeNode root){
        if(root == null) return 0;
        int ls = maxSum(root.left);
        int rs = maxSum(root.right);

        int through_put= root.val + Math.max(0,ls) + Math.max(0,rs);

        maxi =Math.max(maxi,through_put);

        return root.val + Math.max(0,Math.max(ls,rs));
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum(root);

        return maxi;
    }
}