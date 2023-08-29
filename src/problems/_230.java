package problems;

import java.util.Stack;

public class _230 {

    public static void main(String[] args) {
        int res = kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1);
        System.out.println(res);
    }
    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }

    }

    public void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.println(node.left.val);
        }

        System.out.println(node.val);

        if (node.right != null) {
            System.out.println(node.right.val);
        }
    }

}
