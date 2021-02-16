public class LC0029 {
    public int divide(int dividend, int divisor) {
        // Special Cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 0;
        }

        int sign = 1;

        if (dividend > 0) {
            sign = -sign;
            dividend = -dividend;
        }

        if (divisor > 0) {
            sign = -sign;
            divisor = -divisor;
        }

        int res = 0;

        while (dividend - divisor <= 0) {
            dividend -= divisor;
            res++;
        }

        return res * sign;
    }


    // Exponential Search
    // Time Compleity : O(log n)
    // Space Complexity : O(1)
    public int divide1(int dividend, int divisor) {
        // Special Cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;

        if (dividend > 0) {
            sign = -sign;
            dividend = -dividend;
        }

        if (divisor > 0) {
            sign = -sign;
            divisor = -divisor;
        }

        int quotient = 0;

        while (dividend <= divisor) {
            int value = divisor;

            //  Use negative number to deal with case like divide(Integer.MIN_VALUE, 1)
            int multiple = -1;

            while (value >= Integer.MIN_VALUE / 2 && value + value >= dividend) {
                value += value;
                multiple += multiple;
            }

            dividend -= value;
            quotient += multiple;
        }

        return (-quotient) * sign;
    }


    public static void main(String[] args) {
        LC0029 solution = new LC0029();

        solution.divide1(-2147483648, 1);
    }
}
