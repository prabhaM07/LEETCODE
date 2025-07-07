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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> qq = new LinkedList<>();
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val != q.val) return false;
        qq.add(p);
        qq.add(q);

        while(qq.size()>0){
            int n = qq.size();
            for(int i=0;i<n/2;i++){
                TreeNode n1 = qq.poll();
                TreeNode n2 = qq.poll();
                if(n1.val != n2.val) return false;
                if(n1.left!=null && n2.left==null || n1.left==null && n2.left!=null) return false;
                if(n1.left!=null && n2.left!=null){
                    qq.add(n1.left);
                    qq.add(n2.left);
                }
                if(n1.right!=null && n2.right==null || n1.right==null && n2.right!=null) return false;
                if(n1.right!=null && n2.right!=null){
                    qq.add(n1.right);
                    qq.add(n2.right);
                }
            }
        }
        return true;
    }
}