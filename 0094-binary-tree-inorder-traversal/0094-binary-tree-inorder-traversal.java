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
    public TreeNode right_most_node(TreeNode proot,TreeNode root){

        while(root.right !=null){
            
            if(root.right == proot){
                break;
            }
            else
                root = root.right;
        }
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode temp = root;

        while(root!=null){
            if(root.left!=null){
              
                TreeNode t = right_most_node(root,root.left);
                
                if(t.right != root)
                {
                    t.right = root;
                    root = root.left;
                    continue;
                }
                else{
                    t.right = null;
                }
            }
            
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}