class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();
        if (lo > hi) {            // empty range = one "empty tree"
            res.add(null);
            return res;
        }
        for (int root = lo; root <= hi; root++) {
            List<TreeNode> lefts = build(lo, root - 1);
            List<TreeNode> rights = build(root + 1, hi);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode node = new TreeNode(root);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}