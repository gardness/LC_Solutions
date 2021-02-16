public class LC0055 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        return helper(nums, 0);
    }

    private boolean helper(int[] nums, int index) {
        if (index > nums.length - 2) {
            return true;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (helper(nums, index + i)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        boolean[] dp = new boolean[nums.length];

        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int len = Math.min(i + nums[i] + 1, nums.length);

            for (int j = i + 1; j < len; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxSteps = 0;

        for (int num : nums) {
            if (maxSteps < num) {
                maxSteps = num;
            }
        }

        boolean[] dp = new boolean[maxSteps];

        dp[dp.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int len = Math.min(i + nums[i] + 1, dp.length);

            for (int j = i + 1; j < len; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    // Time Complexity : O(kn)
    // Space Complexity : O(n)
    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxSteps = 0;

        for (int num : nums) {
            if (maxSteps < num) {
                maxSteps = num;
            }
        }

        boolean[] dp = new boolean[maxSteps];

        dp[dp.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    // Greedy
    // Time Complexity : O(kn)
    // Space Complexity : O(n)
    public boolean canJump4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxIdx = nums[0];

        for (int i = 0; i < maxIdx + 1; i++) {
            if (maxIdx < i + nums[i]) {
                maxIdx = i + nums[i];
            }

            if (maxIdx >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC0055 solution = new LC0055();

        solution.canJump1(new int[]{2,3,1,1,4});
    }
}
