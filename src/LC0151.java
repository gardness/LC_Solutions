public class LC0151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String newString = removeExcessSpaces(s.toCharArray());
        char[] chars = newString.toCharArray();

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

    // Not reversing words in quote like 'new york'
    public String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String newString = removeExcessSpaces(s.toCharArray());
        char[] chars = newString.toCharArray();

        reverse(chars, 0, chars.length - 1);

        int slow = 0;
        int fast = 0;

        while (fast < chars.length) {
            while (fast < chars.length && (chars[fast] == ' ')) {
                fast++;
            }

            if (chars[fast] == '\'') {
                slow = ++fast;

                while (fast < chars.length && chars[fast] != '\'') {
                    fast++;
                }
            } else {
                slow = fast;

                while (fast < chars.length && chars[fast] != ' ') {
                    fast++;
                }
            }

            reverse(chars, slow, fast - 1);
        }

        return new String(chars);
    }


    public static void main(String[] args) {
        LC0151 solution = new LC0151();

        solution.reverseWords1("Let us go to 'new york'");
    }
}
