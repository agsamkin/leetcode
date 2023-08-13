package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _90 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        result(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public static void result(int[] nums, List<List<Integer>> res, List<Integer> tmp, int index) {
        res.add(new ArrayList<>(tmp));
        for(int i=index;i<nums.length;i++){
            if(i!=index && nums[i]==nums[i-1]) {
                continue;//for duplicate checking
            }
            tmp.add(nums[i]);
            result(nums, res, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

}
