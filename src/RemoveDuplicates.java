public class RemoveDuplicates {
    // Q3.1 Remove duplicated adjacent letters / sorted letters with one left / two left / no one left

    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() <= k) {
            return s;
        }

        char[] chars = s.toCharArray();
        int slow = k;

        for (int fast = k; fast < s.length(); fast++) {
            if (chars[fast] == chars[slow - k]) {
                continue;
            }

            chars[slow++] = chars[fast];
        }

        if (slow == 0) {
            return "";
        }

        return new String(chars, 0, slow);
    }
}
