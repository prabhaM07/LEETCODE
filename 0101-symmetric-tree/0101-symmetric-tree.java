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
    char ch;
    Pair(TreeNode node,char ch){
        this.node = node;
        this.ch = ch;
    }
}
class Solution {
    boolean flag = true;

    void dfs(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return;
        }

        if(root1 == null || root2 == null || root1.val != root2.val){
            flag = false;
            return ;
        }

        Stack<Pair> st1 = new Stack<>();
        Stack<Pair> st2 = new Stack<>();
        
        st1.add(new Pair(root1,'l'));
        st2.add(new Pair(root2,'r'));

        while(st1.size()>0 && st2.size()>0){
            Pair p1 = st1.pop();
            Pair p2 = st2.pop();
            
            if(p1.node.val != p2.node.val || p1.ch == p2.ch){
                flag = false;
                return;
            }

            if(p1.node.left != null){
                st1.add(new Pair(p1.node.left,'l'));  
            }
            if(p1.node.right != null){
                 st1.add(new Pair(p1.node.right,'r'));
            }
            if(p2.node.right!=null){
                st2.add(new Pair(p2.node.right,'r'));
            }
            if(p2.node.left!=null){
                st2.add(new Pair(p2.node.left,'l'));
            }
            
        }
        if(st1.size()>0 || st2.size()>0){
            flag = false;
        }
       
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        dfs(root.left,root.right);

        return flag;
    }
}