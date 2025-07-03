class Solution {
    public boolean DFS(int[][] graph, int n, int sc, Boolean[] v, Boolean[] c, int p) {
        v[sc] = true;
        if (p != -1 && !c[p]) {  // Ensure parent is valid before checking color
            c[sc] = true;
        }
        
        for (int nbr : graph[sc]) {
            if (v[nbr]) {
                if (c[nbr] == c[sc]) {
                    return false;
                }
            } else {
                if (!DFS(graph, n, nbr, v, c, sc)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Boolean[] c = new Boolean[n];
        Boolean[] v = new Boolean[n];

        for (int i = 0; i < n; i++) {
            c[i] = false;
            v[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                if (!DFS(graph, n, i, v, c, -1)) { // Use -1 as the initial parent
                    return false;
                }
            }
        }
        return true;
    }
}