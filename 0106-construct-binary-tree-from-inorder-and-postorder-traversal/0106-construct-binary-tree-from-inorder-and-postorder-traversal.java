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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder,int ins,int ine,int[] postorder,int pos,int poe){
        if(ins>ine || pos>poe){
            return null;
        }
        TreeNode root = new TreeNode(postorder[poe]);

        int k=0;
        for(int i=ins;i<=ine;i++){
            if(inorder[i]==root.val){
                k=i;
                break;
            }
        }

        int no_of_left = (k - ins)-1;

        root.left = build(inorder,ins,k-1,postorder,pos,no_of_left+pos);
        root.right = build(inorder,k+1,ine,postorder,no_of_left+pos+1,poe-1);

        return root;
    }
}