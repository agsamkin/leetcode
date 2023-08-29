package problems;

public class _70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] memory = new int[n + 1];
        memory[1] = 1;
        memory[2] = 2;
        return getResult(n, memory);
    }

    public static int getResult(int n, int[] memory) {
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = getResult(n - 1, memory) + getResult(n - 2, memory);
        return memory[n];
    }

}
