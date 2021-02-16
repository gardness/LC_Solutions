import java.util.*;

public class LC0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();

        dfs(nums, 0, res);

        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            List<Integer> tmp = new LinkedList<>();

            for (int num : nums) {
                tmp.add(num);
            }

            res.add(tmp);

            return;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, index, i);
                dfs(nums, index + 1, res);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];

        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        LC0047 solution = new LC0047();

        solution.permuteUnique(new int[]{1, 1, 2});
    }
}
