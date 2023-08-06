package problems;

import java.util.Set;
import java.util.TreeSet;

public class _128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] sort = new int[nums.length];

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        var iter = set.iterator();
        int last = iter.next();
        int maxlen = 1;
        int len = 1;
        while (iter.hasNext()) {
            int curr = iter.next();
            int diff = curr - last;
            last = curr;
            if (diff != 1) {
                maxlen = Math.max(maxlen, len);
                len = 1;
                continue;
            }

            len++;
        }
        maxlen = Math.max(maxlen, len);
        return maxlen;
    }
}
