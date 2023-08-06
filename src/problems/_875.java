package problems;

public class _875 {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[] {3,6,7,11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min_speed = 1;
        int max_speed = 1;

        for (int i = 0; i < piles.length; i++) {
            max_speed = Math.max(max_speed, piles[i]);
        }

        while (min_speed < max_speed) {
            int mid_speed = (min_speed + max_speed) / 2;
            if (check(piles, h, mid_speed)) {
                max_speed = mid_speed;
            } else {
                min_speed = mid_speed + 1;
            }
        }

        return min_speed;

    }

    private static boolean check(int[] piles, int total_h, int mid_speed) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int pile_h = piles[i] / mid_speed;
            hours += pile_h;
            if (piles[i] % mid_speed != 0) {
                hours++;
            }
        }
        if (hours <= total_h) {
            return true;
        }
        return false;
    }
}
