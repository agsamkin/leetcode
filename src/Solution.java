import java.beans.IntrospectionException;
import java.util.HashMap;

public class Solution {

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

    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int climbStairs(int n) {

        if (n==1) {return 1;}
        else if (n==2) {return 2;}
        else if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        else {
            int tmp = climbStairs(n-1) + climbStairs(n-2);
            hashMap.put(n, tmp);
            return tmp;
        }

    }

}
