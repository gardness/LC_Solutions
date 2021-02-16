import ADT.TreeNode;

import java.util.*;

public class LC0958 {

    // no-level BFS
    public boolean isCompleteTree(TreeNode root) {
        // cc
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();

            if (flag == false && tmp == null) {
                flag = true;
            }

            if (tmp != null && flag == true) {
                return false;
            }

            if (tmp != null) {
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }

        return true;
    }


    // level BFS with null nodes, not preferred
    public boolean isCompleteTree1(TreeNode root) {
        // cc
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        boolean flag = false;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (flag == false && tmp == null) {
                    flag = true;
                }

                if (flag == true && tmp != null) {
                    return false;
                }

                if (tmp != null) {
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
        }

        return true;
    }


    // level BFS with null nodes, preferred
    public boolean isCompleteTree2(TreeNode root) {
        // cc
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        boolean flag = false;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (tmp == null) {
                    flag = true;
                } else {
                    if (flag == true) {
                        return false;
                    }

                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
        }

        return true;
    }


    // level BFS with no null nodes, preferred
    public boolean isCompleteTree3(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        int size = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                if (tmp.left != null) {
                    if (flag == true) {
                        return false;
                    }

                    queue.offer(tmp.left);
                } else {
                    flag = true;
                }

                if (tmp.right != null) {
                    if (flag == true) {
                        return false;
                    }

                    queue.offer(tmp.right);
                } else {
                    flag = true;
                }
            }
        }

        return true;
    }
}
