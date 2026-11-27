class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n + 1];
        int[] cand1 = null;
        int[] cand2 = null;

        for (int[] e : edges) {
            if (par[e[1]] != 0) {
                cand1 = new int[]{par[e[1]], e[1]};
                cand2 = e;
            } else {
                par[e[1]] = e[0];
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            if (e == cand2) {
                continue;
            }
            int u = find(e[0]);
            int v = find(e[1]);
            if (u == v) {
                return cand1 != null ? cand1 : e;
            }
            parent[v] = u;
        }

        return cand2;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}