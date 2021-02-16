import ADT.TreeNode;

import java.util.*;

public class LC0314 {
    class MyNode {
        TreeNode node;
        int col;

        MyNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    // BFS
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<MyNode> queue = new LinkedList<>();
        int size = 0;
        int minCol = 0;
        int maxCol = 0;

        queue.offer(new MyNode(root, 0));

        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                MyNode tmp = queue.poll();
                List<Integer> list = map.getOrDefault(tmp.col, new LinkedList<>());

                list.add(tmp.node.val);
                map.put(tmp.col, list);

                if (tmp.node.left != null) {
                    int curCol = tmp.col - 1;

                    if (curCol < minCol) {
                        minCol = curCol;
                    }

                    queue.offer(new MyNode(tmp.node.left, curCol));
                }

                if (tmp.node.right != null) {
                    int curCol = tmp.col + 1;

                    if (curCol > maxCol) {
                        maxCol = curCol;
                    }

                    queue.offer(new MyNode(tmp.node.right, curCol));
                }
            }
        }

        for (int i = minCol; i < maxCol + 1; i++) {
            res.add(map.get(i));
        }

        return res;
    }


    List<List<Integer>> res = new LinkedList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int minCol = 0;
    int maxCol = 0;



    // DFS
    public List<List<Integer>> verticalOrder1(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        dfs(root, 0);

        for (int i = minCol; i < maxCol + 1; i++) {
            List<Integer> tmp = map.get(i);
            Collections.sort(tmp);
            res.add(tmp);
        }

        return res;
    }


    private void dfs(TreeNode root, int col) {
        // base
        if (root == null) {
            return;
        }

        List<Integer> list = map.getOrDefault(col, new LinkedList<>());

        list.add(root.val);
        map.put(col, list);

        if (col < minCol) {
            minCol = col;
        }

        if (col > maxCol) {
            maxCol = col;
        }

        dfs(root.left, col - 1);
        dfs(root.right, col + 1);
    }
}
