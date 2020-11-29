import ADT.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0144 {
    List<Integer> res = new LinkedList<>();

    // Recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        // cc
        if (root == null) {
            return res;
        }

        res.add(root.val);

        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return res;
    }

    // Iteration
    public List<Integer> preorderTraversal1(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                cur = top.right;
            }
        }

        return res;
    }
}
