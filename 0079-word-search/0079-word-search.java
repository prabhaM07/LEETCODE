class Solution {
    public boolean dfs(char[][] board, String word,int i,boolean[][] v,int sr,int sc,int n,int m){

        if(i==word.length()) return true;

        if(sr<0 || sr>=n || sc<0 || sc>=m ||  v[sr][sc] == true || board[sr][sc] != word.charAt(i)){
            return false;
        }
        
        v[sr][sc] = true;

        
        int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};

        for(int[] k : dict){
            int nsr = k[0];
            int nsc = k[1];
            if(dfs(board,word,i+1,v,nsr,nsc,n,m)) return true;
        }

        v[sr][sc] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m = board[0].length;
        boolean[][] v = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!v[i][j]){
                    if(dfs(board,word,0,v,i,j,n,m)) return true;;
                }
            }
        }
        return false;
    }
}