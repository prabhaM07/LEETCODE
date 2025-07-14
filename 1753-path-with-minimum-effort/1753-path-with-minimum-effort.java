class Pair{
    int sr;
    int sc;
    int dif;
    Pair(int sr,int sc,int dif){
        this.sr = sr;
        this.sc = sc;
        this.dif = dif;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        boolean[][] v = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
                v[i][j] = false;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dif-b.dif);
        pq.add(new Pair(0,0,-1));
        

        while(pq.size()>0){
            //remove
            Pair rem = pq.poll();
            int sr = rem.sr;
            int sc = rem.sc;
            int sdif = rem.dif;

            //work
            if(v[sr][sc]==true) continue;
            v[sr][sc] = true;

            int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};

            for(int[] k : dict){
                int cr = k[0];
                int cc = k[1];
                if(cr>=0 && cr<n && cc>=0 && cc<m && v[cr][cc]==false)
                {
                    int dif =  Math.abs(heights[sr][sc]-heights[cr][cc]);
                    
                    if(dif >= sdif && dif < dist[cr][cc]){
                        dist[cr][cc] = dif;
                        pq.add(new Pair(cr,cc,dif));
                    }
                    else if(sdif >= dif && sdif < dist[cr][cc]){
                        dist[cr][cc] = sdif;
                        pq.add(new Pair(cr,cc,sdif));
                    }
                }
            }
        }
        return dist[n-1][m-1] == Integer.MAX_VALUE ? 0 : dist[n-1][m-1];
    }
}