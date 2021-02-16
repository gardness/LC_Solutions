public class LC0072 {
    // DP
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[len1][len2];
    }

    // DP Optimized
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }

        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len2 + 1];

        for (int i = 0; i < len2 + 1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < len1 + 1; i++) {
            dp[0] = i;

            int topLeftValue = i - 1;
            int prevAboveValue;

            for (int j = 1; j < len2 + 1; j++) {
                prevAboveValue = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = topLeftValue;
                } else {
                    dp[j] = Math.min(topLeftValue, Math.min(dp[j - 1], dp[j])) + 1;
                }

                topLeftValue = prevAboveValue;
            }
        }

        return dp[len2];
    }

    public static void main(String[] args) {
        LC0072 solution = new LC0072();

        solution.minDistance1("intention", "execution");
    }
}
