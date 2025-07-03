class Pair {
    int cur;
    int parent;
    Pair(int c, int p) {
        this.cur = c;
        this.parent = p;
    }
}

class Solution {
    public boolean dfs(int[][] graph,boolean[] v,boolean[] color,int sc,int p){
        v[sc] = true;
        if(p!=-1 && !color[p]){
            color[sc] = true;
        }
        for(int neigh : graph[sc]){
            if(v[neigh]){
                if(color[neigh] == color[sc]) return false;
            }
            else{
                if(!dfs(graph,v,color,neigh,sc)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int source, int parent, boolean[] v, boolean[] color) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, parent));

        while (q.size() > 0) {
            Pair rem = q.poll();
            int c = rem.cur;
            int p = rem.parent;

            if (p!=-1 && !color[p]) {
                color[c] = true;
            }

            v[c] = true;

            for (int neigh : graph[c]) {
                if (!v[neigh]) {
                    q.add(new Pair(neigh, c));
                } else if (color[neigh] == color[c])  {
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        boolean[] c = new boolean[n];
        boolean[] v = new boolean[n]; // single visited array reused

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                if (!dfs(graph,v, c,i, -1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
