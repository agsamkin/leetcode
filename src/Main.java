import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res = solution.isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck");
        System.out.println(res);

    }

}
