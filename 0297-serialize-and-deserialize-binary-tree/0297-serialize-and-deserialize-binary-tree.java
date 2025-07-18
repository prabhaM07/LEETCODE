/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if(root==null) return s;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        s+= root.val;
        s+=',';
        while(q.size()>0){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode k = q.poll();
                if(k.left != null){
                    q.add(k.left);
                    s+=k.left.val;
                }
                else{
                    s+='#';

                }
                s+=',';
                if(k.right != null){
                    q.add(k.right);
                    s+=k.right.val;
                }
                else{
                    s+='#';
                }
                s+=',';
            }
        }
        return s;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s.equals("")) return null;

        List<String> result = new ArrayList<>();
        String ss= "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ','){
                result.add(ss);
                ss = "";
                continue;
            }
            ss+=ch;
        }
        System.out.print(result);
        TreeNode root = new TreeNode(Integer.parseInt(result.get(0)));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i=1;

        while(q.size()>0){
            int n = q.size();
            for(int j=0;j<n;j++){
                TreeNode k = q.poll();
                String chl = result.get(i);
                i++;
                if(!chl.equals("#")){
                    TreeNode temp = new TreeNode(Integer.parseInt(chl));
                    k.left = temp;
                    q.add(temp);
                }
                else{
                    k.left = null;
                }
                String chr = result.get(i);
                i++;
                if(!chr.equals("#")){
                    TreeNode temp = new TreeNode(Integer.parseInt(chr));
                    k.right = temp;
                    q.add(temp);
                }
                else{
                    k.right = null;
                } 
            }
        }
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));