class Pair{
    int index;
    TreeNode node;
    Pair(TreeNode node,int index){
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        int ans = 1;

        q.add(new Pair(root,1));
        while(q.size()>0){
            int n = q.size();
            boolean flag = false;
            int left=0;

            for(int i=0;i<n;i++){
                //remove
                Pair rem = q.poll();
                int index = rem.index;
                TreeNode node = rem.node;

                if(flag == false)
                {
                    flag = true;
                    left = index;
                }
                if((index - left)+1 > ans)
                    ans = (index - left)+1;

                //add
                if(node.left != null){
                    q.add(new Pair(node.left,index*2));
                }
                if(node.right != null){
                    q.add(new Pair(node.right,(index*2)+1));
                }
            }
            
        }
        return ans;
    }
}
