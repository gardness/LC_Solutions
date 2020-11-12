public class LC0070 {

    // 3
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];

        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        // Base Case
        if (n <= 2) {
            return n;
        } else if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = climbStairs(n -1) + climbStairs(n - 2);

        return memo[n];
    }
}
