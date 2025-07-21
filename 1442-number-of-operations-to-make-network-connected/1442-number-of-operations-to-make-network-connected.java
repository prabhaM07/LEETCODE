class Solution {
    int findParent(int[] par,int n){
        if(par[n] == n) return n;
        return findParent(par,par[n]);
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

         int[] par = new int[n];
        
        for(int i=0;i<n;i++){
            par[i] = i;
        }
        for(int i = 0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            int up = findParent(par,u);
            int vp = findParent(par,v);
            if(up == vp) continue;
            par[vp] = up;
        }
        Set<Integer> s = new HashSet<>();

        for(int i=0;i<n;i++){
            s.add(findParent(par,i));
        }
        return s.size()-1;

    }
}