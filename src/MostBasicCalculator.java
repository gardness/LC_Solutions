public class MostBasicCalculator {
    // The expression string only contains non-negative integers, + and - operators.
    // Expression can start with - operator.
    // 2 - 1 + 3
    public int calculate(String s) {
        // cc
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        int num = 0;
        int sign = 1;
        char[] chs = s.toCharArray();
        int i = 0;

        while (i < chs.length) {
            if (chs[i] == '-') {
                sign = -1;
                i++;
            } else if (chs[i] == '+') {
                sign = 1;
                i++;
            } else if (chs[i] >= '0' && chs[i] <= '9') {
                num = chs[i++] - '0';
                while (i < chs.length && (chs[i] >= '0' && chs[i] <= '9')) {
                    num *= 10;
                    num += chs[i++] - '0';
                }
                sum += sign * num;      //  Don't forget the sign
            } else {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MostBasicCalculator solution = new MostBasicCalculator();
        solution.calculate(new String("-11+33-40"));
    }
}
