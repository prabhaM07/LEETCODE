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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> qq = new LinkedList<>();
        qq.add(root);
        int k=1;
        while(qq.size()>0){
            int n = qq.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = qq.poll();
                temp.add(node.val);
                if(node.left!=null) qq.add(node.left);
                if(node.right!=null) qq.add(node.right);
            }
            if(k%2==0) Collections.reverse(temp);
            k++;
            ans.add(temp);
        }
        return ans;
    }
}