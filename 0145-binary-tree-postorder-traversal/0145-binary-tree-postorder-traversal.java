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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        Set<TreeNode> v = new HashSet<>();
        

        List<Integer> ans = new ArrayList<>();
        boolean flag;

        if(root == null) return ans;
        while(st.size()>0){
            TreeNode temp = st.peek();
            flag = false;

            if(temp.right != null && !v.contains(temp.right)){
                flag = true;
                st.push(temp.right);
            }
            if(temp.left != null && !v.contains(temp.left)){
                flag = true;
                st.push(temp.left);
            }
            if(flag) continue;

            temp = st.pop();
            v.add(temp);
            ans.add(temp.val);
        }
        return ans;
}
}