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
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        
        while(q.size()>0){
            int n = q.size();

            for(int i=0;i<n;i++){
                boolean flag = false;
                int sum = 0;

                //remove
                TreeNode node = q.poll();
                int val = node.val;
                
                //add
                if(node.left != null){
                    q.add(node.left);
                    flag = true;
                    sum+= node.left.val;
                }
                if(node.right != null){
                    q.add(node.right);
                    flag = true;
                    sum+= node.right.val;
                }
                
                if(flag == true && sum!=val)
                    return false;
            }
        }
        return true;
    }
}