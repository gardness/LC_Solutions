import ADT.*;

import java.util.LinkedList;
import java.util.Queue;

public class LC0111 {
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public int minDepth(TreeNode root) {
        // cc & base case
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }


    // BFS
    // Time Complexity : O(n)
    // Space Complexity : O(n), n/2 + 1 nodes in the queue at most
    public int minDepth1(TreeNode root) {
        // cc
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int minDepth = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();
            minDepth++;

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (tmp.left == null && tmp.right == null) {
                    return minDepth;
                }

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }

        return 0;
    }
}
