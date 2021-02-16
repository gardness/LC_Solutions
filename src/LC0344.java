public class LC0344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            swap(s, left, right);

            left++;
            right--;
        }

        return;
    }

    private void swap(char[] s, int left, int right) {
        char tmp = s[left];

        s[left] = s[right];
        s[right] = tmp;
    }

    // Recursion, operate before calling recursion
    public void reverseString1(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        helper(s, 0, s.length - 1);

        return;
    }

    private void helper(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        swap(s, left, right);
        helper(s, ++left, --right);
    }


    // Recursion, operate after calling recursion
    public void reverseString2(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        helper1(s, 0, s.length - 1);

        return;
    }

    private void helper1(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        helper1(s, left + 1, right - 1);
        swap(s, left, right);
    }
}