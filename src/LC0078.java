import java.util.*;

public class LC0078 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new LinkedList<>();

        dfs(nums, 0, new LinkedList<>(), res);

        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        List<Integer> curRes = new LinkedList<Integer>();

        for (Integer cur : list) {
            curRes.add(cur);       //  Integer is immutable!
        }

        res.add(curRes);

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }


    private void dfs1(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> curRes = new LinkedList<>();

            for (Integer cur : list) {
                curRes.add(cur);
            }

            res.add(curRes);

            return;
        }

        list.add(nums[index]);
        dfs1(nums, index + 1, list, res);
        list.remove(list.size() - 1);

        dfs1(nums, index + 1, list, res);
    }

    // bfs 2, each level means if current nums[level] has been added to the result
    public List<List<Integer>> subsets1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        int level = -1;

        queue.offer(new LinkedList<>());

        while (++level < nums.length) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                List<Integer> cur = queue.poll();
                List<Integer> newList = new LinkedList<>();

                for (Integer tmp : cur) {
                    newList.add(tmp);
                }

                newList.add(level);
                queue.offer(cur);
                queue.offer(newList);
            }
        }

        List<List<Integer>> res = new LinkedList<>();

        for (List<Integer> list : queue) {
            List<Integer> tmp = new LinkedList<>();

            for (Integer idx : list) {
                tmp.add(nums[idx]);
            }

            res.add(tmp);
        }

        return res;
    }


    // bfs 1, each level means we can choose one element from the elements that are left
    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        List<List<Integer>> resList = new LinkedList<>();
        List<Integer> fst = new LinkedList<>();

        queue.offer(fst);
        resList.add(fst);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                List<Integer> list = queue.poll();

                int start = list.size() == 0 ? -1 : list.get(list.size() - 1);

                while (++start < nums.length) {
                    List<Integer> newList = new LinkedList<>();

                    for (Integer tmp : list) {
                        newList.add(tmp);
                    }

                    newList.add(start);
                    queue.offer(newList);
                    resList.add(newList);
                }
            }
        }

        List<List<Integer>> res = new LinkedList<>();

        for (List<Integer> list : resList) {
            List<Integer> tmp = new LinkedList<>();

            for (Integer idx : list) {
                tmp.add(nums[idx]);
            }

            res.add(tmp);
        }

        return res;
    }
}
