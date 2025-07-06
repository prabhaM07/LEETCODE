class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {

    void dfs(int[][] board,int sr,int sc,int n,int m,boolean[][] v){
        if(sr<0 || sr>=n || sc<0 || sc>=m || board[sr][sc] == 0 || !v[sr][sc]){
            return;
        }

        v[sr][sc] = false;

        int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};

        for(int[] k : dict){
            dfs(board,k[0],k[1],n,m,v);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] v = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]== 1){
                    if((i==0 || j==0 || i==n-1 || j== m-1))
                        q.add(new Pair(i,j));
                    v[i][j] = true;
                }
                else
                v[i][j] = false;
            }
        }
        

        while(q.size()>0){
            Pair rem = q.poll();
            int sr = rem.i;
            int sc = rem.j;
            if(v[sr][sc])
            dfs(grid,sr,sc,n,m,v);
        }
        int c =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(v[i][j]==true){
                    c++;
                }
            }
        }
        return c;
    }
}
