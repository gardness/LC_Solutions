public class LC0008 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.trim().toCharArray();
        int sign = 1;
        int res = 0;

        if (chars.length == 0) {
            return 0;
        }

        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] == '+') {
            sign = 1;
        } else if (chars[0] < '0' || chars[0] > '9') {
            return 0;
        } else {
            res = -(chars[0] - '0');
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }

            int digit = - (chars[i] - '0');

            if (sign == -1) {
                if (res < Integer.MIN_VALUE / 10
                        || (res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (res < Integer.MIN_VALUE / 10
                        || (res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10 + 1)) {
                    return Integer.MAX_VALUE;
                }
            }

            res = res * 10 + digit;
        }

        return (-res) * sign;
    }
}
