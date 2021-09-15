import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        list1.next = list2;
        ListNode list3 = new ListNode(2);
        list2.next = list3;
        ListNode list4 = new ListNode(1);
        list3.next = list4;
        System.out.println(solution.isPalindrome(list1));



    }

}

