import java.util.*;

class DisjointSet {
    int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findUpar(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findUpar(parent[node]); // path compression
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);

        if (ulp_u == ulp_v) return;

        if (size[ulp_v] < size[ulp_u]) {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        } else {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int targetCell = (n - 1) * n + (n - 1);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        DisjointSet ds = new DisjointSet(n * n);
        int[] vis = new int[n * n];

        List<int[]> flat = new ArrayList<>();

        // Flatten the grid
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                flat.add(new int[]{grid[r][c], r, c});
            }
        }

        // Sort by elevation
        flat.sort(Comparator.comparingInt(a -> a[0]));

        for (int[] it : flat) {
            int ele = it[0];
            int r = it[1];
            int c = it[2];

            int cell = r * n + c;
            vis[cell] = 1;

            // Connect neighbors if visited
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n) {
                    int ncell = nrow * n + ncol;
                    if (vis[ncell] == 1) {
                        ds.unionBySize(cell, ncell);
                    }
                }
            }

            // Check if source and target are connected
            if (ds.findUpar(0) == ds.findUpar(targetCell)) {
                return ele;
            }
        }

        return -1; // unreachable
    }
}
