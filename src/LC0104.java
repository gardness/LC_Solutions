import ADT.*;

import java.util.LinkedList;
import java.util.Queue;

public class LC0104 {
    // DFS
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int maxDepth(TreeNode root) {
        // cc & base case
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // BFS
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int maxDepth1(TreeNode root) {
        // cc
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int maxDepth = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();
            maxDepth++;

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return maxDepth;
    }
}
