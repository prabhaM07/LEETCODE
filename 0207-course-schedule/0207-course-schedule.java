class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;

        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        int[] in = new int[V];
        
        for(int[] e : prerequisites){
            graph[e[0]].add(e[1]);
            in[e[1]]+=1;
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
            c++;
            
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
        return c==V;
    }
}