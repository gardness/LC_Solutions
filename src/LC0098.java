import ADT.*;

import java.util.*;

public class LC0098 {
    // S1 : Top-down approach
    // Using integer object to handle Integer.MAX_VALUE & Integer.MIN_VALUE
    public boolean isValidBST(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        // base case
        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    // Using long instead of Integer object to handle Integer.MAX_VALUE & Integer.MIN_VALUE
    public boolean isValidBST1(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        return isValidBST1(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValidBST1(TreeNode root, long min, long max) {
        // base case
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST1(root.left, min, root.val) && isValidBST1(root.right, root.val, max);
    }


    // S2 : Bottom-top approach
    public boolean isValidBST2(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        return helper(root) != null;
    }

    // res[0] means min value of current tree, res[1] means max value of current tree
    private Integer[] helper(TreeNode root) {
        // base case
        if (root == null) {
            return new Integer[]{null, null};
        }

        Integer[] left = helper(root.left);
        Integer[] right = helper(root.right);

        if ((left == null || right == null)
                || ((left[1] == null && right[0] != null) && (root.val >= right[0]))
                || ((left[1] != null && right[0] == null) && (root.val <= left[1]))
                || ((left[1] != null && right[0] != null) && (root.val <= left[1] || root.val >= right[0]))) {
            return null;
        }

        if (left[0] == null && left[1] == null && right[0] == null && right[1] == null) {
            return new Integer[]{root.val, root.val};
        }

        if (left[0] == null) {
            return new Integer[]{root.val, right[1]};
        }

        if (right[1] == null) {
            return new Integer[]{left[0], root.val};
        }

        return new Integer[]{left[0], right[1]};
    }


    // S3 : using the property of BST, in-order traversal
    // Using a list to store the result
    public boolean isValidBST3(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        List<Integer> res = new LinkedList<>();

        inOrder(res, root);

        for (int i = 1; i < res.size(); i++) {
            if (res.get(i - 1) >=  res.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(res, root.left);
        res.add(root.val);
        inOrder(res, root.right);
    }


    TreeNode prev = null;

    // S4 : using the property of BST, in-order traversal
    // Using a prev global variable
    public boolean isValidBST4(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        boolean left = isValidBST4(root.left);

        if (prev != null && prev.val >= root.val) {
            return false;
        }

        prev = root;

        boolean right = isValidBST4(root.right);

        return left == true && right == true;
    }


    // S5 : using the property of BST, in-order traversal
    // Using a prev local variable
    public boolean isValidBST5(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();

                if (prev != null && prev.val >= top.val) {
                    return false;
                }

                prev = top;
                cur = top.right;
            }
        }

        return true;
    }


    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//
//        ListIterator iterator = list.listIterator();
//
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//        }
//
//        System.out.println();
//
//        while (iterator.hasPrevious()) {
//            System.out.print(iterator.previous() + " ");
//        }

        TreeGenerator treeGenerator = new TreeGenerator();
        TreeNode root = treeGenerator.deserialize("5,1,4,#,#,3,6");
        LC0098 solution = new LC0098();
        solution.isValidBST5(root);
    }
}