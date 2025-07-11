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
        
        Deque<Pair> dq = new LinkedList<>();
        int ans = 1;

        dq.add(new Pair(root,1));
        while(dq.size()>0){
            int n = dq.size();
            boolean flag = false;
            int left=0;

            for(int i=0;i<n;i++){
                //remove
                Pair rem = dq.poll();
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
                    dq.add(new Pair(node.left,index*2));
                }
                if(node.right != null){
                    dq.add(new Pair(node.right,(index*2)+1));
                }
            }
            
        }
        return ans;
    }
}
