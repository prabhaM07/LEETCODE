class Solution {

    public void dfs(char[][] grid,int sr,int sc,int n,int m){

        if(sr<0 || sr>=n || sc<0 || sc>=m || grid[sr][sc]=='0'){
            return;
        }

        grid[sr][sc]='0';

        int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};

        for(int[] k : dict){
            int nsr = k[0];
            int nsc = k[1];
            dfs(grid,nsr,nsc,n,m);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int c=0;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]=='1'){
                    c+=1;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return c;
    }
}