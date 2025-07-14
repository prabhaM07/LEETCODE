class Pair{
    int node;
    int w;
    Pair(int node,int w){
        this.node = node;
        this.w = w;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int rem) {
        int m = flights[0].length;

        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }   

      
            for(int[] k : flights){
                graph[k[0]].add(new Pair(k[1],k[2]));
            }
        

        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src,0));
        int k=-1;
        int[] dict = new int[n];
        
        Arrays.fill(dict,Integer.MAX_VALUE);
        dict[src] = 0;

        while(pq.size()>0){
            int size = pq.size();
            k++;
            if(k>rem) break;
            for(int i=0;i<size;i++){
                Pair p = pq.poll();

                int sn = p.node;
                int sw = p.w;

                for(Pair neigh : graph[sn]){
                    int cn = neigh.node;
                    int cw = neigh.w;
                    int t = sw+cw;
                    if(t<dict[cn]){
                        dict[cn] = t;
                        pq.add(new Pair(cn,t));
                    }
                }
            }
        }
        return dict[dst] == Integer.MAX_VALUE ? -1 : dict[dst];
    }
}