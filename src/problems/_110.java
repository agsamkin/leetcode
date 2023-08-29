package problems;

public class _110 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root) != -1;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (Math.abs(l - r) < 2) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

}
