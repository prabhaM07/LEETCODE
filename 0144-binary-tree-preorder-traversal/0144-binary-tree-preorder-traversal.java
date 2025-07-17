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

    public TreeNode last(TreeNode proot,TreeNode root){
        
        while(true){
            if(root.right == null && root.left == null) break;

            if(root.right !=null ){
                if(root.right == proot){
                    break;
                }
                else
                    root = root.right;
            }
            else if(root.left != null){
                if(root.left == proot){
                    break;
                }
                else
                    root = root.left;
            }
        }
        return root;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
        TreeNode temp = root;

        while(root!=null){
            ans.add(root.val);

            if(root.left!=null && root.right!=null){
              
                TreeNode t = last(root,root.left);

                if(t.right != root.right)
                {
                    t.right = root.right;
                    root = root.left;
                    continue;
                }
                else{
                    t.right = null;
                }
            }
            else{
                if(root.right!=null)root = root.right;
                else root = root.left;
            }
            
        }
        return ans;
    }
}