package problems;

public class _98 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }
        return dfs(root.left, root.val, min) && dfs(root.right, max, root.val);
    }
}
