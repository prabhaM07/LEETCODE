class Pair{
    int sr;
    int sc;
    int sw;
    Pair(int sr,int sc,int sw){
        this.sr = sr;
        this.sc = sc;
        this.sw = sw;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1) return -1;

        boolean[][] v = new boolean[n][n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sw - b.sw);

        pq.add(new Pair(0,0,1));

        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.MAX_VALUE;
                v[i][j] = false;
            }
        }

        dist[0][0] = 1;

        while(pq.size()>0){

            //remove
            Pair p = pq.poll();
            int sr = p.sr;
            int sc = p.sc;
            int sw = p.sw;

            //work
            v[sr][sc] = true;

            //add
            int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1},{sr-1,sc+1},{sr+1,sc+1},{sr+1,sc-1},{sr-1,sc-1}};

            for(int[] k : dict){
                int cr = k[0];
                int cc = k[1];
                int tw = sw+1;
                if(cr>=0 && cr<n && cc>=0 && cc<n && !v[cr][cc] && grid[cr][cc] == 0 && tw < dist[cr][cc]){
                        dist[cr][cc] = tw;
                        pq.add(new Pair(cr,cc,tw));
                  
                }
            }
        }
        return dist[n-1][n-1] < Integer.MAX_VALUE ? dist[n-1][n-1] : -1;
    }
}