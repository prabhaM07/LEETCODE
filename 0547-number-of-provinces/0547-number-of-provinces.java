class Solution {
    public void dfs(ArrayList<Integer>[] graph,boolean[] v, int node){

        if(!v[node]){
            v[node] = true;
        }

        for(int neigh : graph[node]){
            if(!v[neigh]){
                dfs(graph,v,neigh);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i!=j && isConnected[i][j]==1){
                    graph[i].add(j);
                }
            }
        }
           
        boolean[] v = new boolean[V];
        int c =0;
        for(int i=0;i<V;i++){
            if(!v[i]){
                c++;
                dfs(graph,v,i);
              
            }
        }
        return c;
    }
    
}