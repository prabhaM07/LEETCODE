class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    dist[i][j] = 0;     
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
            
        }
        for(int i=0;i<edges.length;i++){
            if(edges[i][2]<=distanceThreshold){
                dist[edges[i][0]][edges[i][1]] = edges[i][2];
                dist[edges[i][1]][edges[i][0]] = edges[i][2];
            }
            
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!= Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k]+dist[k][j] <= distanceThreshold){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int ans = -1;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int c = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j] != Integer.MAX_VALUE){
                    c++;
                }
            }
            if(c<=mini){
               mini = c;
               if(i>ans) ans = i;
            }
        }
        return ans;
    }
}