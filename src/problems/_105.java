package problems;

import java.util.Arrays;

public class _105 {
    public static void main(String[] args) {
        buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int splitIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                splitIndex = i;
                break;
            }
        }
        int[] io_left = Arrays.copyOfRange(inorder, 0, splitIndex);
        int[] io_right = Arrays.copyOfRange(inorder, splitIndex+1, inorder.length);

        int[] po_left = Arrays.copyOfRange(preorder, 1, io_left.length + 1);
        int[] po_right = Arrays.copyOfRange(preorder, io_left.length + 1, preorder.length);
        root.left = buildTree(po_left, io_left);
        root.right = buildTree(po_right, io_right);
        return root;
    }
}
