import ADT.TreeNode;

import java.util.*;

public class LC0107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // cc
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
                TreeNode tmp = queue.poll();

                list.add(tmp.val);

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

            res.add(list);
        }

        Collections.reverse(res);

        return res;
    }
}
