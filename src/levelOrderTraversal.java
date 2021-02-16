import ADT.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            res.add(list);
        }

        return res;
    }


    // include all nil nodes
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur == null) {
                    list.add(null);
                } else {
                    list.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }

            res.add(list);
        }

        return res;
    }


    // dfs
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int depth = 0;

    public List<List<Integer>> levelOrderByDFS(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();

        dfs(root);

        for (int i = 0; i < map.size(); i++) {
            res.add(map.get(i));
        }

        return res;
    }

    private void dfs(TreeNode root) {
        // cc
        if (root == null) {
            return;
        }

        List<Integer> tmp = map.getOrDefault(depth, new LinkedList<Integer>());

        tmp.add(root.val);
        map.put(depth++, tmp);

        if (root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }

        depth--;
    }
}
