import java.util.*;

class DisjointSet {
    private int[] parent, size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); // Path compression
        }
        return parent[u];
    }

    public void unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        DisjointSet dsu = new DisjointSet(total);

        List<int[]> cells = new ArrayList<>();

        // Step 1: Flatten grid with elevation and coordinates
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{grid[i][j], i, j});
            }
        }

        // Step 2: Sort by elevation
        cells.sort(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int[] cell : cells) {
            int h = cell[0];
            int i = cell[1];
            int j = cell[2];
            visited[i][j] = true;
            int curr = i * n + j;

            // Union with visited neighbors
            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && visited[ni][nj]) {
                    int neigh = ni * n + nj;
                    dsu.unionBySize(curr, neigh);
                }
            }

            // Check if top-left is connected to bottom-right
            if (dsu.connected(0, total - 1)) {
                return h;
            }
        }

        return -1; // fallback
    }
}
