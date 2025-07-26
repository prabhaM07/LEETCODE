import java.util.*;

class Solution {
    public int findParent(int[] par, int n) {
        if (par[n] == n) return n;
        par[n] = findParent(par, par[n]);
        return par[n];
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

            if (findParent(par, 0) == findParent(par, target)) {
                return ele;
            }
        }

        return -1;
    }
}
