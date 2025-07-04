class Solution {
    public void dfs(int[][] image,int sr,int sc,int c,int o,int n,int m){
        if(sr<0 || sr>=n || sc<0 || sc>=m || image[sr][sc]!=o || image[sr][sc]==c){
            return;
        }
        image[sr][sc] = c;

        int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};
        for(int[] k : dict){
            int nsr = k[0];
            int nsc = k[1];
            dfs(image,nsr,nsc,c,o,n,m);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            dfs(image,sr,sc,color,image[sr][sc],image.length,image[0].length);
            return image;
    }
}