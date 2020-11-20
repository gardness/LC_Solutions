import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import ADT.*;

public class LC0145 {
    /*
        1. push
        2. finish left subtree
        3. finish right subtree
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        stack.push(cur);

        while (!stack.isEmpty()) {
            cur = stack.peek();

            if (prev == null || prev.left == cur || prev.right == cur) {    // case 1
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    TreeNode top = stack.pop();
                    res.add(top.val);
                }
            } else if (prev == cur.left) {      //  case 2
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    TreeNode top = stack.pop();
                    res.add(top.val);
                }
            } else if (prev == cur.right) {     //  case 3
                TreeNode top = stack.pop();
                res.add(top.val);
            }

            prev = cur;
        }

        return res;
    }
}
