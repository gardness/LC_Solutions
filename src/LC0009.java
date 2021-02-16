public class LC0009 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int tmp = 0;

        while (tmp < x) {
            int digit = x % 10;

            tmp = tmp * 10 + digit;
            x /= 10;
        }

        if (tmp == x || tmp / 10 == x) {
            return true;
        }

        return false;
    }
}
