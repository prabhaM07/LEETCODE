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
       TreeNode temp = root;

       List<Integer> ans = new ArrayList<>();
       List<TreeNode> rem = new ArrayList<>();
       if(root == null) return ans;
       while(st.size()>0){
            while(temp.left != null){
                st.push(temp.left);
                temp = temp.left;
            }
              
            while(st.size()>0){
                temp = st.peek();
                if(temp.right != null && !rem.contains(temp.right)){
                    st.push(temp.right);
                    temp = temp.right;
                    break;
                }
                else{
                    temp = st.pop();
                    ans.add(temp.val);
                    rem.add(temp);
                }
            }
            
       } 
       return ans;
    }
}