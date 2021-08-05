import java.beans.IntrospectionException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class Solution {

    //region 1. Two Sum
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];

        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int tmp = target - nums[i];
            if (numsMap.containsKey(tmp)) {
                int val = numsMap.get(tmp);
                res[0] = val;
                res[1] = i;
                break;
            }

            numsMap.put(nums[i], i);

        }

        return res;

    }
    //endregion

    //region 7. Reverse Integer
    public int reverse(int x) {

        int rev = 0;
        while (x!=0) {

            int pop = x % 10;

            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }

            x /= 10;
            rev = rev * 10 + pop;

        }
        return rev;

    }
    //endregion

    //region 9. Palindrome Number
    public boolean isPalindrome(int x) {

        if (x ==0) {
            return true;
        }

        if (x < 0) {
            return false;
        }

        int rev = reverse(x);

        if (rev == 0) {
            return false;
        }

        return (x == rev);

    }
    //endregion

    //region 13. Roman to Integer
    public int romanToInt(String s) {

        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int res = 0;

        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int x1 = romanMap.get(str[i]);
            int x2 = 0;
            if ((i+1) < s.length()) {
                x2 = romanMap.get(str[i+1]);
            }
            if (x1 < x2) {
                res = res - x1;
            } else {
                res = res + x1;
            }
        }

        return res;

    }
    //endregion

    //region 14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];

        if (strs.length == 1) {
            return res;
        }

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length()-1);
                if (res.isEmpty()) {
                    return "";
                }
            }
        }

        return res;
    }
    //endregion

    //region 20. Valid Parentheses
    public boolean isValid(String s) {

        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (!brackets.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '*' : stack.pop();
                if (top!=brackets.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
    //endregion

    //region 21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode();

        if (l1.val < l2.val) {
            res.val = l1.val;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res.val = l2.val;
            res.next = mergeTwoLists(l2.next, l1);
        }

        return res;

    }
    //endregion

    //region 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {

        int res = 0;

        Set<Integer> set = new HashSet<>();

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            int tmp = nums[i];

            if (set.contains(tmp)) {
                continue;
            } else {
                nums[j] = tmp;
                set.add(tmp);
                j++;
            }

        }

        return set.size();

    }
    //endregion

    //region 27. Remove Element
    public int removeElement(int[] nums, int val) {

        int res = nums.length;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            int tmp = nums[i];
            if (tmp == val) {
                res--;
                continue;
            } else {
                nums[j++] = tmp;
            }
        }

        return res;

    }
    //endregion

    //region 28. Implement strStr()
    public int strStr(String haystack, String needle) {

        if (haystack.isEmpty() && needle.isEmpty()) {
            return 0;
        }

        char[] arr = haystack.toCharArray();

        for (int left = 0; left < arr.length - needle.length() + 1; left++) {

            if (haystack.substring(left, left+needle.length()).equals(needle)) {
                return left;
            }

        }

        return -1;

    }
    //endregion

    //region 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length;

        while (left <= right) {

            int split = (right + left) / 2;

            if (split >= nums.length) {
                return left;
            }

            int tmp = nums[split];

            if (tmp == target) {return split;}

            if (tmp > target) {
                right = split-1;
            } else {
                left = split+1;
            }

        }

        return left;

    }
    //endregion

    //region 53. Maximum Subarray
    public int maxSubArray(int[] nums) {

        if (nums.length==0) {return 0;}

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if(sum > max) {
                max = sum;
            }
            for (int i1 = i+1; i1 < nums.length; i1++) {
                sum = sum + nums[i1];
                if(sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
    //endregion

    //region 58. Length of Last Word
    public int lengthOfLastWord(String s) {

        String[] arr = s.split(" ");

        if (arr.length == 0) {
            return 0;
        } else {
            return arr[arr.length-1].toCharArray().length;
        }

    }
    //endregion

    //region 66. Plus One
    public int[] plusOne(int[] digits) {

        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        for (int i = digits.length; i > 0; i--) {

            int tmp = digits[i-1];
            if(i == digits.length) {
                tmp++;
            }

            tmp += count;

            if (tmp > 9) {
                tmp = 0;
                count = 1;
            } else {
                count = 0;
            }

            list.add(0, tmp);
        }

        if (count > 0) {
            list.add(0,1);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;

    }
    //endregion

    //region 67. Add Binary
    public String addBinary(String a, String b) {

        if (a.length() > b.length()) {
            int tmp = a.length() - b.length();
            for (int i = 0; i < tmp; i++) {
                b = "0" + b;
            }
        }

        if (a.length() < b.length()) {
            int tmp = b.length() - a.length();
            for (int i = 0; i < tmp; i++) {
                a = "0" + a;
            }
        }

        int length = a.length();

        char[] chars_a = a.toCharArray();
        char[] chars_b = b.toCharArray();

        String res = "";
        boolean needAdd = false;

        for(int i = length; i > 0; i--) {

            char char_a = ' ';
            char char_b = ' ';

            char_a = chars_a[i-1];
            char_b = chars_b[i-1];

            char char_c = ' ';

            if (char_a == '1' && char_b == '1' && needAdd) {
                char_c = '1';
                needAdd = true;
            } else if (char_a == '1' && char_b == '1') {
                char_c = '0';
                needAdd = true;
            } else if (char_a == '0' && char_b == '0' && needAdd) {
                char_c = '1';
                needAdd = false;
            } else if (char_a == '0' && char_b == '0') {
                char_c = '0';
                needAdd = false;
            } else if (char_a == '0' && char_b == '1' && needAdd || char_a == '1' && char_b == '0' && needAdd) {
                char_c = '0';
                needAdd = true;
            } else if (char_a == '0' && char_b == '1' || char_a == '1' && char_b == '0') {
                char_c = '1';
                needAdd = false;
            } else {
                char_c = '0';
                needAdd = false;
            }

            res = char_c + res;

        }

        if (needAdd) {
            res = "1" + res;
        }

        return res;

    }
    //endregion

    //region 69. Sqrt(x)
    public int mySqrt(int x) {

        int res = 0;

        int min = 1;
        int max = x%2 == 0 ? x/2 : (x/2)+1;

        while (max>=min) {

            int mid = (min+max)/2;

            if (mid>Integer.MAX_VALUE/mid) {
                max = mid-1;
                continue;
            }

           int tmp = mid*mid;

           if (tmp==x) {res = mid; break;}
           if (tmp>x) {max = mid-1;}
           if (tmp<x) {min = mid+1;}

        }

        if (res == 0) {
            res = min-1;
        }

        return res;

    }
    //endregion

    //region 70. Climbing Stairs
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int climbStairs(int n) {

//        if (n==1) {return 1;}
//        else if (n==2) {return 2;}
//        else if (hashMap.containsKey(n)) {
//            return hashMap.get(n);
//        }
//        else {
//            int tmp = climbStairs(n-1) + climbStairs(n-2);
//            hashMap.put(n, tmp);
//            return tmp;
//        }

        hashMap.put(1, 1);
        hashMap.put(2, 2);

        int res = 0;
        for (int i = 3; i <= n; i++) {
            int tmp = hashMap.get(i-1) + hashMap.get(i-2);
            hashMap.put(i, tmp);
        }

        return hashMap.get(n);

    }
    //endregion

    //region 83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();

        ListNode lastNode = null;
        ListNode newHead = head;
        while (newHead.next != null) {

            if (set.contains(newHead.val)) {
                lastNode.next = newHead.next;
            } else {
                lastNode = newHead;
                set.add(newHead.val);
            }

            newHead = newHead.next;

        }

        if (lastNode!= null && set.contains(newHead.val)) {
            lastNode.next = null;
        }

        return head;

    }
    //endregion

    //region 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length == 0) {
            return;
        }

        int nn = n - 1;
        int mm = m - 1;
        for (int i = nums1.length-1; i >= 0; i--) {

            if (nn < 0 && mm >= 0) {
                nums1[i] = nums1[mm];
                mm--;
                continue;
            }

            if (mm < 0 && nn >= 0) {
                nums1[i] = nums2[nn];
                nn--;
                continue;
            }

            if (nums1[mm] > nums2[nn]) {
                nums1[i] = nums1[mm];
                mm--;
            } else {
                nums1[i] = nums2[nn];
                nn--;
            }

        }

    }
    //endregion

    //region 94. Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) { return res; }

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;

    }
    //endregion

    //region 100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {

        boolean res = false;

        if (p == null & q == null) {
            return true;
        }

        if (p != null && q != null) {

            if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                res = true;
            }

        }

        return res;

    }
    //endregion

    //region 101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {

        boolean res = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                res = false;
                break;
            }

            if (left.val != right.val) {
                res = false;
                break;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);

        }

        return res;

    }
    //endregion

    //region 104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        res++;
        res = res + Math.max(maxDepth(root.left), maxDepth(root.right));

        return res;

    }
    //endregion

    //region 108. Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {return null;}

        int mid = nums.length/2;
        int[] l = Arrays.copyOfRange(nums, 0, mid);
        int[] r = Arrays.copyOfRange(nums, mid+1, nums.length);
        TreeNode root = new TreeNode(nums[mid], sortedArrayToBST(l), sortedArrayToBST(r));

        return root;

    }
    //endregion

    //region 110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {

        boolean res = false;

        if (root == null) {return true;}

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        if (l>r) {
            res = (l-r) <= 1;
        } else {
            res = (r-l) <= 1;
        }

        if(res && isBalanced(root.left) && isBalanced(root.right)) {
            res = true;
        } else {res = false;}

        return res;

    }
    //endregion

    //region 111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {

        int res = 0;

        if (root == null) {
            return res;
        }

        res++;

        if(root.left == null || root.right == null) {
            if(root.left == null) {
                res = res + minDepth(root.right);
            } else {
                res = res + minDepth(root.left);
            }
        } else {
            res = res + Math.min(minDepth(root.left), minDepth(root.right));
        }

        return res;

    }
    //endregion

    //region 112. Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        targetSum = targetSum - root.val;

        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
        }
        
    }
    //endregion

    //region 118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {

        List rows = new LinkedList();
        List<Integer> lastRow = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new LinkedList<>();

            for (int j = 0; j < i; j++) {
                int tmp = 1;
                if (j > 0) {
                    tmp = lastRow.get(j-1) + lastRow.get(j);
                }
                row.add(tmp);
            }
            row.add(1);
            rows.add(row);
            lastRow = row;

        }

        return rows;

    }
    //endregion

    //region 119. Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {

        List<Integer> lastRow = new LinkedList<>();

        for (int i = 0; i < rowIndex; i++) {

            List<Integer> row = new LinkedList<>();

            for (int j = 0; j < i; j++) {
                int tmp = 1;
                if (j > 0) {
                    tmp = lastRow.get(j-1) + lastRow.get(j);
                }
                row.add(tmp);
            }
            row.add(1);
            lastRow = row;

        }

        return lastRow;

    }
    //endregion

    //region 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i];
            if (tmp > min) {
                maxProfit = Math.max(maxProfit, (tmp-min));
            } else {
                min = tmp;
            }

        }

        return maxProfit;

    }
    //endregion

    //region 122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {

        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            int tmp = prices[i];
            if (tmp > min) {
                maxProfit = maxProfit + (tmp-min);
            }
            min = tmp;

        }

        return maxProfit;

    }
    //endregion

    //region 125. Valid Palindrome
    public boolean isPalindrome(String s) {

        boolean res = true;

        s = s.replaceAll("[^a-zA-ZА-Яа-я0-9\\s]", "").replace(" ", "").toLowerCase();

        int mid = s.length()/2;
        char[] arr = s.toCharArray();
        for (int i = 0; i < mid; i++) {
            if (arr[i] != arr[arr.length-i-1]) {
                res = false;
                break;
            }
        }

        return res;

    }
    //endregion

    //region 136. Single Number
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
    //endregion

    //region 141. Linked List Cycle
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            ListNode currentNode = head.next;
            if (set.contains(currentNode)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;

    }
    //endregion

    //region 144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));

        return list;

    }
    //endregion

    //region 145. Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);

        return list;

    }
    //endregion

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
