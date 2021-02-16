public class LC0005 {
    private String longestString = "";

    // Traverse the string from the middle, pick all possible staring and ending positions for a substring
    // Time Complexity : O(n^3), can be reduce to O(n^2) if the unnecessary re-computation is eliminated
    // Space Complexity : O(1)
    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        if (s.length() == 0) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            for (int len = 0; len <= s.length() / 2; len++) {
                boolean[] flag = new boolean[2];

                flag[0] = !isPalindrome(s, i - len, i + len);
                flag[1] = !isPalindrome(s, i - len, i + 1 + len);

                if (flag[0] && flag[1]) {
                    break;
                }
            }
        }

        return longestString;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || end > s.length() - 1) {
            return false;
        }

        int l = start;
        int r = end;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        if (longestString.length() < end - start + 1) {
            longestString = new String(s.toCharArray(), start, end - start + 1);
        }

        return true;
    }


    // Traverse the string from the middle, checking each substring by expanding around its center
    public String longestPalindrome1(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        if (s.length() == 0) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            boolean[] flag = new boolean[2];

            flag[0] = !isPalindrome1(s, i, i);
            flag[1] = !isPalindrome1(s, i, i + 1);

            if (flag[0] && flag[1]) {
                break;
            }
        }

        return longestString;
    }

    private boolean isPalindrome1(String s, int start, int end) {
        if (start < 0 || end > s.length() - 1) {
            return false;
        }

        int left = start + (end - start) / 2;
        int right = start + (end - start + 1) / 2;

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        if (longestString.length() < right - left - 1) {
            longestString = s.substring(left + 1, right);
        }

        return true;
    }

    // DP
    // Time Complexity : O(n^2)
    // Space Complexity : O(n^2)
    public String longestPalindrome2(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i + 1 < n) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        for (int i = n - 1; i >= 0 ; i++) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = (dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
            }
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == true && end - start + 1 < j - i + 1) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        LC0005 solution = new LC0005();

        solution.longestPalindrome2("aaaaa");
    }
}
