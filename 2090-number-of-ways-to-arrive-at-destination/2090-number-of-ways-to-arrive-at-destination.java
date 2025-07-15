class Pair {
    int node;
    long w; // use long here
    Pair(int node, long w) {
        this.node = node;
        this.w = w;
    }
}

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] r : roads){
            graph[r[0]].add(new Pair(r[1], r[2]));
            graph[r[1]].add(new Pair(r[0], r[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.w, b.w));
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int sn = p.node;
            long sw = p.w;

            if(sw > dist[sn]) continue;

            for(Pair neigh : graph[sn]){
                int cn = neigh.node;
                long cw = neigh.w;
                long t = sw + cw;

                if(t < dist[cn]){
                    dist[cn] = t;
                    ways[cn] = ways[sn];
                    pq.add(new Pair(cn, t));
                } else if(t == dist[cn]){
                    ways[cn] = (ways[cn] + ways[sn]) % MOD;
                }
            }
        }
        return (int) ways[n-1];
    }
}
