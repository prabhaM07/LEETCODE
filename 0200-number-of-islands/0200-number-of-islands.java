class Solution {
    public void DFS(int sr,int sc,char[][] grid){
        if(sr<0 || sc<0 || sr>=grid.length || sc>= grid[0].length || grid[sr][sc]=='0'){
            return;
        }
        if(grid[sr][sc]=='1'){
            grid[sr][sc] = '0';
        }

        //UP
        DFS(sr-1,sc,grid);
        //right
        DFS(sr,sc+1,grid);
        //down
        DFS(sr+1,sc,grid);
        //left
        DFS(sr,sc-1,grid);


    }
    public int numIslands(char[][] grid) {

       int c = 0;
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]=='1'){
                   c+=1;
                   DFS(i,j,grid);
               }
           }
       }

        return c;

    }
}