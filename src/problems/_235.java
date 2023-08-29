package problems;

import com.sun.source.tree.BreakTree;

public class _235 {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    public static TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return node;
        }
        if (node.val > p.val && node.val > q.val) {
            return dfs(node.left, p, q);
        }
        if (node.val < p.val && node.val < q.val) {
            return dfs(node.right, p, q);
        }
        return node;
    }

}
