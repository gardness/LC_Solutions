public class LC0028 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.equals("")) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;

                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }

                    j++;
                }

                if (j == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
