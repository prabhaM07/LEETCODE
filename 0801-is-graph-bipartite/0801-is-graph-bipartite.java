class Pair{
    int cur;
    int parent;
    Pair(int c,int p){
        this.cur = c;
        this.parent =p;
    }
}

class Solution {
    public boolean bfs(int[][] graph,int source,int parent,boolean[] v,boolean[] color){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source,parent));
        
        while(q.size()>0){
            Pair rem = q.poll();
            int c=rem.cur;
            int p=rem.parent;
            
            if(!v[c]){
                if(p==-1)
                    color[c] = true;
                else color[c] = !color[p];
            }
            else{
                if(color[c]==color[p]){
                    return false;
                }
            }
            v[c] = true;

            for(int neigh : graph[c]){

                if(!v[neigh]){
                    q.add(new Pair(neigh,c));
                }
                else{
                    if(color[neigh]==color[c]){
                        return false;
                    }
                }
            }
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        
        boolean[] c = new boolean[n];
       
        for(int i=0;i<n;i++){
            boolean[] v = new boolean[n];
            if(!bfs(graph,i,-1,v,c)){
                return false;
            }
        }
        return true;
        
    }
}
