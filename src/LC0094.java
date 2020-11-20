import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import ADT.*;

public class LC0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                res.add(top.val);
                cur = top.right;
            }
        }

        return res;
    }
}
