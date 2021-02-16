import java.util.Arrays;

public class LC0300 {
    // [10,9,2,5,3,7,101,18]
    public int lengthOfLIS0(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return lengthOfLIS0(nums, Integer.MIN_VALUE, 0);
    }

    private int lengthOfLIS0(int[] nums, int prev, int curPos) {
        // Base Case
        if (curPos == nums.length) {
            return 0;
        }

        int taken = 0;
        if (prev < nums[curPos]) {
            taken = 1 + lengthOfLIS0(nums, nums[curPos], curPos + 1);
        }

        int nontaken = lengthOfLIS0(nums, prev, curPos + 1);

        return Math.max(taken, nontaken);
    }


    // [10,9,2,5,3,7,101,18], recursion with memorization
    public int lengthOfLIS1(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] memo = new int[nums.length + 1][nums.length];

        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }

        return lengthOfLIS1(nums, -1, 0, memo);
    }

    private int lengthOfLIS1(int[] nums, int prevIdx, int curPos, int[][] memo) {
        // Base Case
        if (curPos == nums.length) {
            return 0;
        }

        if (memo[prevIdx + 1][curPos] != -1) {
            return memo[prevIdx + 1][curPos];
        }

        int taken = 0;

        if (prevIdx < 0 || nums[prevIdx] < nums[curPos]) {
            taken = 1 + lengthOfLIS1(nums, curPos, curPos + 1, memo);
        }

        int nontaken = lengthOfLIS1(nums, prevIdx, curPos + 1, memo);

        memo[prevIdx + 1][curPos] = Math.max(taken, nontaken);

        return memo[prevIdx + 1][curPos];
    }


    public static void main(String[] args) {
        LC0300 solution = new LC0300();
        solution.lengthOfLIS0(new int[]{-2, -1});
    }
}
