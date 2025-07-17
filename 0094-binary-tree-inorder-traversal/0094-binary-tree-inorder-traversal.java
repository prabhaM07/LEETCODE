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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> v = new HashSet<>();

       if(root == null) return ans; 
       Stack<TreeNode> st = new Stack<>();
       st.push(root);
       while(st.peek().left != null){
            st.push(st.peek().left);
       }
       while(st.size()>0){
            if(st.peek().left != null && !v.contains(st.peek().left)){
                st.push(st.peek().left);
                continue;
            }

            TreeNode temp = st.pop();
            v.add(temp);
            ans.add(temp.val);
            
            if(temp.right!= null && !v.contains(temp.right)){
                st.push(temp.right);
            }
       }
       return ans;
    }
}