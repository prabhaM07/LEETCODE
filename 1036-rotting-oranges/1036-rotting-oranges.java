class Pair{
    int sr;
    int sc;
    Pair(int sr,int sc){
        this.sr = sr;
        this.sc = sc;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh ==0) return 0;
        int level = -1;
        while(q.size()>0){
            int k = q.size();
            level++;

            for(int i=0;i<k;i++){
                Pair rem = q.poll();
                int sr = rem.sr;
                int sc = rem.sc;

                int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};

                for(int[] neigh : dict){
                    int cr = neigh[0];
                    int cc = neigh[1];
                    if(cr>=0 && cr<n && cc>=0 && cc<m && grid[cr][cc]==1){
                        q.add(new Pair(cr,cc));
                        grid[cr][cc] = 2;
                        fresh--;
                    }
                }

            }
        }
        System.out.print(fresh);
        if(fresh ==0) return level;
        else return -1;
    }
}