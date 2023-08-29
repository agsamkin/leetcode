package problems;

public class _1448 {
    int count = 0;
    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode node, int max) {
        if (node.val >= max) {
            count++;
            max = Math.max(max, node.val);
        }
        if (node.left != null) dfs(node.left, max);
        if (node.right != null) dfs(node.right, max);
    }
}
