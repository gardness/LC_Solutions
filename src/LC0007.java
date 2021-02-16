public class LC0007 {
//    // Not recommended, under no circumstances should overflows happen.
//    public int reverse(int x) {
//        int num = x;
//        int res = 0;
//
//        while (num != 0) {
//            int digit = num % 10;
//            int newRes = res * 10 + digit;
//
//            if (newRes / 10 != res) {
//                return 0;
//            }
//
//            res = newRes;
//            num /= 10;
//        }
//
//        return res;
//    }

    public int reverse1(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;

            x /= 10;

            if ((rev > Integer.MAX_VALUE / 10)
                    || (rev == Integer.MAX_VALUE / 10 && pop > (Integer.MAX_VALUE) % 10)
                    || (rev < Integer.MIN_VALUE / 10)
                    || (rev == Integer.MAX_VALUE / 10 && pop < (Integer.MIN_VALUE) % 10)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }
}
