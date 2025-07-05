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

class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node,int num){
        this.node = node;
        this.num = num;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<Pair> st = new Stack<>();
       
        ArrayList<Integer> preOrder = new ArrayList<>();
        if(root == null)
         return preOrder;
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        st.push(new Pair(root,1));
        while(st.size()>0){
            Pair temp = st.pop();
            
            if(temp.num==1){
                preOrder.add(temp.node.val);
                temp.num++;
                st.push(temp);
                if(temp.node.left != null)
                    st.push(new Pair(temp.node.left,1));
            }
            else if(temp.num ==2){
                inOrder.add(temp.node.val);
                temp.num++;
                st.push(temp);
                if(temp.node.right != null)
                    st.push(new Pair(temp.node.right,1));
            }
            else{
                postOrder.add(temp.node.val);
            }
        }
        return preOrder;
    }
}