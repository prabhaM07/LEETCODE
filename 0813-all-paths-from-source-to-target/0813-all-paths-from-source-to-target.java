
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public void dfs(int[][] graph,int source,boolean[] v,int n){
        if(v[source]){
            return;
        }
        temp.add(source);
        v[source] = true;

        if(source == n-1){
            ans.add(new ArrayList<>(temp)); 
        }
         
        for(int neigh : graph[source]){
            if(!v[neigh]){
                dfs(graph,neigh,v,n);
               
            }
        }
        temp.remove(temp.size() - 1);
        v[source] = false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[] v = new boolean[n];
        Arrays.fill(v,false);
        dfs(graph,0,v,n);
        return ans;
    }
}