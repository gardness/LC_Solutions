import ADT.TreeNode;

import java.util.*;

public class LC0103 {

    // S1 : reverse
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        int level = 0;

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

            if (level % 2 != 0) {
                Collections.reverse(list);
            }

            res.add(list);
            level %= 2;
            level++;
        }

        return res;
    }


    // S2 : Stack
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Stack<TreeNode> fStack = new Stack<>();
        Stack<TreeNode> sStack = new Stack<>();
        int size = 0;
        int level = 0;

        fStack.push(root);

        while (!fStack.isEmpty() || !sStack.isEmpty()) {
            Stack<TreeNode> fullStack = fStack.isEmpty() ? sStack : fStack;
            Stack<TreeNode> emptyStack = fStack.isEmpty() ? fStack : sStack;
            List<Integer> list = new LinkedList<>();

            while (!fullStack.isEmpty()) {
                TreeNode tmp = fullStack.pop();

                list.add(tmp.val);

                if (level % 2 != 0) {
                    if (tmp.right != null) {
                        emptyStack.push(tmp.right);
                    }

                    if (tmp.left != null) {
                        emptyStack.push(tmp.left);
                    }
                } else {
                    if (tmp.left != null) {
                        emptyStack.push(tmp.left);
                    }

                    if (tmp.right != null) {
                        emptyStack.push(tmp.right);
                    }
                }
            }

            res.add(list);
            level %= 2;
            level++;
        }

        return res;
    }


    // S3 : use deque as a back-to-back stack
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int size = 0;
        int level = 0;

        deque.offerFirst(root);

        while (!deque.isEmpty()) {
            size = deque.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                if (level % 2 != 0) {
                    TreeNode tmp = deque.pollFirst();

                    list.add(tmp.val);

                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }

                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                } else {
                    TreeNode tmp = deque.pollLast();

                    list.add(tmp.val);

                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }

                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                }
            }

            res.add(list);
            level %= 2;
            level++;
        }

        return res;
    }
}
