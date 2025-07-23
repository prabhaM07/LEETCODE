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

class Pair{
    TreeNode n;
    int dif;
    Pair(TreeNode n,int dif){
        this.n = n;
        this.dif = dif;
    }
}
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,-1));

        while(q.size()>0){
            int n = q.size();
            for(int i=0;i<n;i++){
                Pair rem = q.poll();
                TreeNode node = rem.n;
                int dif = rem.dif;
                if(node.left != null){
                    int ldif = Math.abs(node.val - node.left.val);

                    if(node.val <= node.left.val || (ldif > dif && dif != -1)) return false;
                    q.add(new Pair(node.left,ldif));
                }
                if(node.right != null){
                    int rdif = Math.abs(node.val - node.right.val);

                    if(node.val >= node.right.val || (rdif > dif && dif != -1)) return false;
                    q.add(new Pair(node.right,rdif));
                }
            }
        }
        return true;
    }
}