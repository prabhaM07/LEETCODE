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

    int ans = 0;
    int i= 0;
    public void inOrder(TreeNode root, int k) {
        if(root == null) return ;
        
        inOrder(root.left,k);
        i+=1;
        if(i == k){
            ans = root.val;
            return;
        } 
        inOrder(root.right,k);

    }
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }
}