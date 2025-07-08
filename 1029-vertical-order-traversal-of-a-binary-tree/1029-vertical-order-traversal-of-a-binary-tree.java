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
    int w;
    int level;
    Pair(TreeNode node,int w,int level){
        this.node = node;
        this.w = w;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,ArrayList<Integer>> tm = new TreeMap<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.level != b.level) {
                    return a.level - b.level;      // secondary sort by level if w is equal
                } else {
                    return a.node.val - b.node.val; // tertiary sort by node.val if both w and level are equal
                }
            }
        );


        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        pq.add(new Pair(root,0,0));
        while(pq.size()>0){
            int n = pq.size();
            for(int i=0;i<n;i++){
                Pair rem = pq.poll();
                TreeNode node = rem.node;
                int w = rem.w;
                int level = rem.level;
                if(!tm.containsKey(w)){
                    ArrayList<Integer> nn = new ArrayList<>();
                    nn.add(node.val);
                    tm.put(w,nn);
                }
                else{
                    ArrayList<Integer> nn = tm.get(w);
                    nn.add(node.val);
                }

                if(node.left != null){
                    pq.add(new Pair(node.left,w-1,level+1));
                }
                if(node.right != null){
                    pq.add(new Pair(node.right,w+1,level+1));
                }
            }
        }

        
        for(Map.Entry<Integer,ArrayList<Integer>> entry : tm.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}