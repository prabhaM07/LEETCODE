import java.util.*;

class DisjointSet {
    int[] par, size;

    public DisjointSet(int n) {
        par = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public int findParent(int[] par, int node) {
        if (par[node] == node) return node;
        par[node] = findParent(par, par[node]); // path compression
        return par[node];
    }

    public void union(int[] par, int[] size, int up1, int up2) {
        if (size[up1] > size[up2]) {
            par[up2] = up1;
            size[up1] += size[up2];
        } else {
            par[up1] = up2;
            size[up2] += size[up1];
        }
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int target = (n - 1) * n + (n - 1);

        int[] dR = {-1, 0, 1, 0};
        int[] dC = {0, 1, 0, -1};

        int[] par = new int[n * n];
        int[] size = new int[n * n];
        int[] vis = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        List<int[]> flat = new ArrayList<>();

        // Flatten grid
        for (int sr = 0; sr < n; sr++) {
            for (int sc = 0; sc < n; sc++) {
                flat.add(new int[]{grid[sr][sc], sr, sc});
            }
        }

        flat.sort(Comparator.comparingInt(a -> a[0]));

        for (int[] cellArr : flat) {
            int ele = cellArr[0];
            int sr = cellArr[1];
            int sc = cellArr[2];

            int sn = sr * n + sc;
            vis[sn] = 1;

            // connect neighbors
            for (int k = 0; k < 4; k++) {
                int nr = sr + dR[k];
                int nc = sc + dC[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nn = nr * n + nc;
                    if (vis[nn] == 1) {
                        int up1 = findParent(par, sn);
                        int up2 = findParent(par, nn);
                        if (up1 != up2) {
                            union(par, size, up1, up2);
                        }
                    }
                }
            }

            // check connection
            if (findParent(par, 0) == findParent(par, target)) {
                return ele;
            }
        }

        return -1;
    }

    private int findParent(int[] par, int n) {
        if (par[n] == n) return n;
        par[n] = findParent(par, par[n]);
        return par[n];
    }

    private void union(int[] par, int[] size, int up1, int up2) {
        if (size[up1] > size[up2]) {
            par[up2] = up1;
            size[up1] += size[up2];
        } else {
            par[up1] = up2;
            size[up2] += size[up1];
        }
    }
}
