import java.util.Arrays;

public class LC0674 {
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return findLengthOfLCIS(nums, 0, 0, 0);
    }

    // Top-down recursion
    // Find the length of the longest continuous increasing subsequence that ends with i
    private int findLengthOfLCIS(int[] nums, int index, int sum, int max) {
        if (index == nums.length) {
            return max;
        }

        if (index != 0 && nums[index] > nums[index - 1]) {
            sum += 1;
        } else {
            sum = 1;
        }

        max = Math.max(max, sum);

        return findLengthOfLCIS(nums, index + 1, sum, max);
    }


    private int maxLen = 1;

    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        findLengthOfLCIS1(nums, 0);

        return maxLen;
    }

    // Bottom-up recursion
    // Find the length of the longest continuous increasing subsequence that starts with i
    private int findLengthOfLCIS1(int[] nums, int index) {
        if (index == nums.length - 1) {
            return 1;
        }

        int sum = findLengthOfLCIS1(nums, index + 1);

        if (nums[index] < nums[index + 1]) {
            maxLen = Math.max(maxLen, sum + 1);

            return sum + 1;
        }

        return 1;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);
        findLengthOfLCIS2(nums, dp, 0);

        return maxLen;
    }

    // Bottom-up recursion + Memorization
    // Find the length of the longest continuous increasing subsequence that starts with i
    private int findLengthOfLCIS2(int[] nums, int[] dp, int index) {
        if (index == nums.length - 1) {
            return 1;
        }

        int sum = 0;

        if (dp[index + 1] != -1) {
            sum = dp[index + 1];
        } else {
            sum = findLengthOfLCIS2(nums, dp, index + 1);
        }

        if (nums[index] < nums[index + 1]) {
            maxLen = Math.max(maxLen, sum + 1);
            dp[index] = sum + 1;

            return sum + 1;
        }

        dp[index] = 1;

        return 1;
    }

    // DP
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int findLengthOfLCIS3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        dp[nums.length - 1] = 1;

        int max = dp[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                dp[i] = dp[i + 1] + 1;
                max = Math.max(max, dp[i]);
            } else {
                dp[i] = 1;
            }
        }

        return max;
    }

    // DP with O(1) space complexity
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public int findLengthOfLCIS4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 1;
        int cur = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                cur += 1;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }

        return max;
    }
}
