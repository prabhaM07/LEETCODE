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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        q.add(root);
        
        while(q.size()>0){
            int n = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode nn = q.poll();
                temp.add(nn.val);

                if(nn.left != null){
                    q.add(nn.left);
                }
                if(nn.right != null){
                    q.add(nn.right);
                }
            }
            ans.add(temp.get(temp.size()-1));
        }
        return ans;
    }
}