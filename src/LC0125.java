public class LC0125 {
    // Traverse inwards from both ends of the string
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        char[] chars = s.toCharArray();

        int slow = 0;
        int fast = 0;

        while (fast < chars.length) {
            if (chars[fast] >= 'A' && chars[fast] <= 'Z') {
                chars[slow++] = (char) (chars[fast] - 'A' + 'a');
            } else if ((chars[fast] >= 'a' && chars[fast] <= 'z')
                    || (chars[fast] >= '0' && chars[fast] <= '9')) {
                chars[slow++] = chars[fast];
            }

            fast++;
        }

        int len = slow;

        if (len == 0) {
            return true;
        }

        for (int i = 0; i < len / 2 + 1; i++) {
            if (chars[i] != chars[len - 1 - i]) {
                return false;
            }
        }

        return true;
    }

//    // Traverse outwards from the middle of the string
//    public boolean isPalindrome1(String s) {
//
//    }


    public static void main(String[] args) {
        LC0125 solution = new LC0125();

        solution.isPalindrome("A man, a plan, a canal: Panama");
    }
}
