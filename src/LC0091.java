public class LC0091 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.trim().toCharArray();

        int res = 1;

        if (chars[0] == '0') {
            res = 0;
        }

        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                int num = (chars[i - 1] - '0') * 10 + chars[i] - '0';

                if (num > 0 && num < 27) {
                    if (chars[i] != '0') {
                        res++;
                    }
                } else if (chars[i] == '0') {
                    return 0;
                }
            }
        }

        return res;
    }
}
