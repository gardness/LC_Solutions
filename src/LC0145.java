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


    /*
        going down to visit its left subtree :
        finishing up visiting left subtree :
        finishing up visiting right subtree :

     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        // cc
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> res = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            cur = stack.peek();

            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    TreeNode top = stack.pop();
                    res.add(top.val);
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    TreeNode top = stack.pop();
                    res.add(top.val);
                }
            } else if (prev == cur.right) {
                TreeNode top = stack.pop();
                res.add(top.val);
            }

            prev = cur;
        }

        return res;
    }


    // Lao Liu's approach
    public List<Integer> postorderTraversal2(TreeNode root) {
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
                cur = cur.right;
            } else {
                TreeNode top = stack.pop();
                cur = top.left;
            }
        }

        reverse(res);

        return res;
    }

    private void reverse(List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int tmp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, tmp);
            l++;
            r--;
        }
    }
}
