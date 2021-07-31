import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        //root = [3,9,20,null,null,15,7]

//        TreeNode r2 = new TreeNode(7);
//        TreeNode l2 = new TreeNode(15);
//
//        TreeNode r1 = new TreeNode(20, l2, r2);
        TreeNode l1 = new TreeNode(2);

        TreeNode root = new TreeNode(1, l1, null);

        System.out.println(solution.hasPathSum(root, 3));

    }

}
