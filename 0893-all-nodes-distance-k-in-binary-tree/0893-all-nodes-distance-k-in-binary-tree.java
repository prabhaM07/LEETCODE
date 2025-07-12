/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int num) {
        Set<TreeNode> v = new HashSet<>();

        HashMap<TreeNode,TreeNode> hm = new HashMap<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            
            TreeNode k = q.poll();
            
            if(k.left != null)
            {
                q.add(k.left);
                hm.put(k.left,k);
            }
            if(k.right != null)
            {
                q.add(k.right);
                hm.put(k.right,k);
            }
        }

        int dist =-1;
        q.add(target);

        while(q.size()>0){
            int n = q.size();
            dist+=1;
            if(dist == num) break;

            for(int i=0;i<n;i++){
                TreeNode k = q.poll();

                v.add(k);

                if(hm.containsKey(k)){
                    TreeNode temp = hm.get(k);
                    if(!v.contains(temp))
                    q.add(temp);
                }
                if(k.left != null)
                {
                    TreeNode temp = k.left;
                    if(!v.contains(temp))
                    q.add(temp);
                }
                if(k.right != null)
                {
                    TreeNode temp = k.right;
                    if(!v.contains(temp))
                    q.add(temp);
                }
            }
            
        }
        List<Integer> ans = new ArrayList<>();
        while(q.size()>0){
            ans.add(q.poll().val);
        }
        return ans;

    }
}