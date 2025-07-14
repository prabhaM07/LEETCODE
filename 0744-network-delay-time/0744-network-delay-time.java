class Pair{
    int node;
    int w;
    Pair(int node,int w){
        this.node = node;
        this.w = w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] mat : times){
            graph[mat[0]].add(new Pair(mat[1],mat[2]));
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.w - b.w);
        boolean[] v = new boolean[n+1];
        dist[k]=0;
        pq.add(new Pair(k,0));
        
        while(pq.size() > 0){
         
            //remove
            Pair p = pq.poll();
            int sn = p.node;
            int sw = p.w;

            //work
            if(v[sn]) continue;
            v[sn] = true;

            //add
            for(Pair neigh : graph[sn]){
                int cn = neigh.node;
                int cw = neigh.w;
                int t = sw+cw;
                if(!v[cn] && t<dist[cn]){
                    dist[cn] = t;
                    pq.add(new Pair(cn,t));
                }
            }
            
        }
        int maxi = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(dist[i]>maxi) maxi = dist[i];
        }
        return maxi;
    }
}