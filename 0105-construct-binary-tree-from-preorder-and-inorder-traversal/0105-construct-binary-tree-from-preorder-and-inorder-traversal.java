/*
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }

    public TreeNode build(int[] inorder,int ins,int ine,int[] preorder,int pres,int pree){
        if(ins>ine || pres>pree){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pres]);

        int k=0;
        for(int i=ins;i<=ine;i++){
            if(inorder[i]==root.val){
                k=i;
                break;
            }
        }

        int no_of_left = (k - ins);

        root.left = build(inorder,ins,k-1,preorder,pres+1,no_of_left+pres);
        root.right = build(inorder,k+1,ine,preorder,no_of_left+pres+1,pree);

        return root;
    }
}