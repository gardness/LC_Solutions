public class LC0186 {
    public String reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return "";
        }

        char[] chars = s;

        reverse(chars, 0, chars.length - 1);

        int slow = 0;
        int fast = 0;

        while (fast < chars.length) {
            while (fast < chars.length && chars[fast] == ' ') {
                fast++;
            }

            slow = fast;

            while (fast < chars.length && chars[fast] != ' ') {
                fast++;
            }

            reverse(chars, slow, fast - 1);
        }

        return new String(chars);
    }

    // __ab___c__
    private String removeExcessSpaces(char[] chars) {
        int slow = 0;

        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] == ' ' && (fast == 0 || chars[fast - 1] == ' ')) {
                continue;
            }

            chars[slow++] = chars[fast];
        }

        if (slow == 0) {
            return "";
        }

        if (chars[slow - 1] == ' ') {
            return new String(chars, 0, slow - 1);
        }

        return new String(chars, 0, slow);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left, right);

            left++;
            right--;
        }
    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];

        chars[left] = chars[right];
        chars[right] = tmp;
    }
}
