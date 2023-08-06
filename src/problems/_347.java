package problems;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _347 {
    public static void main(String[] args) {
        var res = topKFrequent(new int[] {1}, 1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int mid = 10000;
        int[] freq = new int[mid * 2];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int index = n > 0 ? (mid-1) + n : n * (-1);
            freq[index] += 1;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < freq.length; i++) {
            int f = freq[i];
            if (f == 0) {
                continue;
            }

            int n = i > (mid-1) ? i - mid + 1 : i * (-1);

            if (map.containsKey(f)) {
                List<Integer> ns = map.get(f);
                ns.add(n);
                Collections.sort(ns);
                map.put(f, ns);
            } else {
                List<Integer> ns = new ArrayList<>();
                ns.add(n);
                map.put(f, ns);
            }
        }

        int[] res = new int[k];
        int check = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> ns = e.getValue();
            for (int i = 0; i < ns.size(); i++) {
                res[check++] = ns.get(i);
                if (check == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
