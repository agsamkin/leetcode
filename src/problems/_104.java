package problems;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class _104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0,
                new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null),
                new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(1, null, new TreeNode(8))));
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int max = 0;
        while (!queue.isEmpty()) {
            max++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return max;
    }

//    public static int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
//    }
}

