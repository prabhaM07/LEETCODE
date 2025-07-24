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
    TreeNode node;
    long l;
    long r;
    Pair(TreeNode node,long l,long r){
        this.node = node;
        this.l = l;
        this.r = r;
    }
}
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<Pair> st = new Stack<>();
        if(preorder.length == 0)  return null;
        TreeNode root = new TreeNode(preorder[0]);
        st.push(new Pair(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        int i =1;

        while(st.size()>0 && i<preorder.length){
            int next = preorder[i];
            Pair p = st.peek();
            TreeNode node = p.node;
            long l = p.l;
            long r = p.r;
            System.out.println(next+" "+node.val+" "+l+" "+r);

            if(next<node.val && next>l){
                node.left = new TreeNode(next);
                st.push(new Pair(node.left,l,node.val));
                i++;
            }
            else if(next>node.val && next<r){
                node.right = new TreeNode(next);
                st.push(new Pair(node.right,node.val,r));
                i++;
            }
            else{
                st.pop();
            }
        }
        return root;
    }
}