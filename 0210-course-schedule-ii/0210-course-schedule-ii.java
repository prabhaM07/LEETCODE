class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        int[] ans = new int[V];

        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        int[] in = new int[V];
        
        for(int[] e : prerequisites){
            graph[e[1]].add(e[0]);
            in[e[0]]+=1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        
        int c = 0;

        while(q.size()>0){
            //remove
            int k = q.poll();
            
            //work
            ans[c++] = k;
            
            //add
            for(int neigh : graph[k]){
                if(in[neigh]>0){
                    in[neigh]-=1;
                }
                if(in[neigh]==0){
                    q.add(neigh);
                }
            }
            
        }
        if(c==V){
            return ans;
        }
        return new int[0];
    
    }
}