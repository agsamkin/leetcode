package problems;

public class _134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int need = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                need += tank;
                tank = 0;

            }
        }
        if (tank + need >= 0) {
           return start;
        }
        return -1;
    }
}
