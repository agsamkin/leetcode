package problems;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _846 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[] {1,2,3,4,5}, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < hand.length; i++) {
            min = Math.min(min, hand[i]);
            if (map.containsKey(hand[i])) {
                int count = map.get(hand[i]) + 1;
                map.put(hand[i], count);
            } else {
                map.put(hand[i], 1);
            }
        }

        int groupCount = hand.length / groupSize;
        for (int i = 0; i < groupCount; i++) {
            int next = min;
            for (int j = 0; j < groupSize; j++) {
                if (map.containsKey(next)) {
                    int count = map.get(next) - 1;
                    map.put(next, count);
                    if (count == 0) {
                        map.remove(next);
                        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                            min = e.getKey();
                            break;
                        }
                    }
                } else {
                    return false;
                }
                next++;
            }
        }

        return true;
    }
}
