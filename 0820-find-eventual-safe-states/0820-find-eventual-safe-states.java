class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer>[] adj = new ArrayList[n];

        int[] out = new int[n];

        for(int i=0;i<n;i++){
            out[i] = graph[i].length;
        }

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int neigh : graph[i]){
                adj[neigh].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(out[i]==0) q.add(i);
        }

        while(q.size()>0){
            //remove
            int k = q.poll();

            //work
            ans.add(k);

            //add
            for(int neigh: adj[k]){
                out[neigh] -= 1;
                if(out[neigh] ==0) q.add(neigh);
            }
        }

        Collections.sort(ans);
        
        return ans;
    }
}
