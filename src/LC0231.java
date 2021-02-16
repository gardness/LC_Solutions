public class LC0231 {
    // Recursion, with n == 0 as the exit condition
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        return helper(n);
    }

    private boolean helper(int n) {
        if (n % 2 == 1 && n / 2 != 0) {
            return false;
        }

        if (n == 0) {
            return true;
        }

        return helper(n / 2);
    }

    // Recursion, with n == 1 as the exit condition
    public boolean isPowerOfTwo0(int n) {
        // Corner Case
        if (n <= 0) {
            return false;
        }

        // Base Case for outputting true
        if (n == 1) {
            return true;
        }

        // Base Case for outputting false
        if (n % 2 != 0) {
            return false;
        }

        return isPowerOfTwo0(n / 2);
    }

    // Iteration
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }

        int i = n;

        while (i != 0) {
            if (i % 2 != 0 && i / 2 != 0) {
                return false;
            }

            i /= 2;
        }

        return true;
    }

    // DP
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }

        long i = 1;

        while (i < n) {
            i *= 2;
        }

        return i == n;
    }

    // Bit Manipulation
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }

    // Bit Manipulation
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        int cnt = 2;

        while (n != 0) {
            if (cnt == 0) {
                cnt = 2;
            } else {
                if (n % 2 == 1) {
                    return false;
                }

                cnt--;
            }

            n >>= 1;
        }

        return true;
    }

    public static void main(String[] args) {
        LC0231 solution = new LC0231();

        solution.isPowerOfTwo2(1073741825);
        System.out.println(solution.isPowerOfFour(18));
    }
}
