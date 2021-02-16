public class LC0509 {
    // Top-down recursion
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // Bottom-up recursion + memorization
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }

        int[] mem = new int[n + 1];

        mem[0] = 0;
        mem[1] = 1;

        helper(0, mem, n);

        return mem[n];
    }

    public void helper(int i, int[] mem, int n) {
        if (i > n) {
            return;
        }

        if (i > 1) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }

        helper(i + 1, mem, n);
    }

    // DP
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // DP, space complexity optimized
    public int fib3(int n) {
        if (n < 2) {
            return n;
        }

        int[] nums = new int[2];

        nums[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            int tmp = nums[0] + nums[1];
            nums[0] = nums[1];
            nums[1] = tmp;
        }

        return nums[1];
    }
}
