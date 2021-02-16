import java.util.*;

public class LC0046 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }

        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();

        dfs(nums, visited, 0, new LinkedList<>(), res);

        return res;
    }

    private void dfs(int[] nums, boolean[] visited, int index, List<Integer> perm, List<List<Integer>> res) {
        if (perm.size() == nums.length) {
            List<Integer> list = new LinkedList<>();

            for (Integer tmp : perm) {
                list.add(tmp);
            }

            res.add(list);

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            visited[i] = true;
            perm.add(nums[i]);
            dfs(nums, visited, i + 1, perm, res);
            visited[i] = false;
            perm.remove(perm.size() - 1);
        }
    }


    // Time Complexity : O(n * n!)
    // Space Complexity : O(n + n!)
    public List<List<Integer>> permute1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();

        dfs1(nums, 0, res);

        return res;
    }


    private void dfs1(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            List<Integer> tmp = new LinkedList<>();

            for (int num : nums) {
                tmp.add(num);
            }

            res.add(tmp);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs1(nums, index + 1, res);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];

        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
