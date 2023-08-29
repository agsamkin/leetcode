package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class _543 {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0,
                new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null),
                new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(1, null, new TreeNode(8))));
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = 0;
        if (root.left != null) {
            l = dfs(root.left);
        }
        int r = 0;
        if (root.right != null) {
            r = dfs(root.right);
        }
        max = Math.max(l + r, max);
        return Math.max(l, r) + 1;
    }

}
