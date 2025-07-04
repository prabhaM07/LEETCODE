class Solution {
    public void dfs(ArrayList<Integer>[] graph,boolean[] v, int node,int[] vec){

        if(!v[node]){
            vec[0]+=1;
            v[node] = true;
        }

        for(int neigh : graph[node]){
            vec[1]+=1;
            if(!v[neigh]){
                dfs(graph,v,neigh,vec);
            }
        }
    }
    public int countCompleteComponents(int V, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] k : edges){
            graph[k[0]].add(k[1]);
            graph[k[1]].add(k[0]);
        }
        
        boolean[] v = new boolean[V];
        
        int c = 0;
        for(int i=0;i<V;i++){
            if(!v[i]){
                int[] vec = new int[2];
                Arrays.fill(vec,0);
                dfs(graph,v,i,vec);
                int n = vec[0] * (vec[0]-1);
                if(vec[1] == n) c++;
                System.out.println(vec[0]+" "+vec[1]);
            }
        }
        return c;
    }
}