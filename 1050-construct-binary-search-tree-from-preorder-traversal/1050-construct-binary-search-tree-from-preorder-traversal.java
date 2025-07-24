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
    public TreeNode create(int[] preorder,int[] index,int maxi,int n){
        if(index[0] >= n || preorder[index[0]] > maxi) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        
        root.left = create(preorder,index,preorder[index[0]-1],n);
        root.right = create(preorder,index,maxi,n);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] n = new int[1];
        n[0] = 0;
        return create(preorder,n,Integer.MAX_VALUE,preorder.length);
    }
}