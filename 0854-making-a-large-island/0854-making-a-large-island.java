class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r = r;
        this.c = c;
    }
}
class Solution {  
    public int findParent(int[] par,int n){
        if(par[n]==n) return n;
        par[n] = findParent(par,par[n]);
        return par[n];
    }

    public void union(int[] par,int[] size,int up1,int up2){
        
        if(size[up1]>size[up2]){
            par[up2] = up1;
            size[up1] += size[up2];
        }
        else{
            par[up1] = up2;
            size[up2] += size[up1];
        }
    } 

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int par[] = new int[n*n];
        int size[] = new int[n*n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int temp = (i*n)+j;
                par[temp] = temp;
                size[temp] = 1;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sr = i;
                int sc = j;
                int sn = (sr*n)+sc;
                if(grid[sr][sc] == 1) c++;
                boolean flag = false;

                int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};
                for(int[] k : dict){
                    int cr = k[0];
                    int cc = k[1];

                    if(cr <0 || cr>=n || cc<0 || cc>=n || grid[cr][cc]==0) continue;

                    if(grid[sr][sc] == 0){
                        flag = true;
                        continue;
                    }
                    
                    int cn = (cr*n)+cc;
                    int up1 = findParent(par,sn);
                    int up2 = findParent(par,cn);
                    if(up1 != up2)
                    union(par,size,up1,up2);
                }

                if(flag){
                    q.add(new Pair(sr,sc));
                }

            }
        }
        int maxi = 1;

        while(q.size()>0){
            Pair p = q.poll();
            int sr = p.r;
            int sc = p.c;
            int sn = grid[sr][sc];

            int[][] dict = {{sr-1,sc},{sr,sc+1},{sr+1,sc},{sr,sc-1}};
            
            Set<Integer> ulparents = new HashSet<>();
            for(int[] k : dict){
                    int cr = k[0];
                    int cc = k[1];

                    if(cr <0 || cr>=n || cc<0 || cc>=n || grid[cr][cc]==0) continue;
                    int cn = (cr*n)+cc;
                    int up = findParent(par,cn);
                    ulparents.add(up);

            }

            int sum = size[sn];
            for(int up : ulparents){
                sum+= size[up];
            }

            maxi = Math.max(maxi,sum);
        }

        return c ==  (n*n) ? c : maxi;
    }
}