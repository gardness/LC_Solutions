import ADT.*;

public class LC0110 {
    // top-down approach
    public boolean isBalanced(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        // cc & base case
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return getHeight(root.right) + 1;
        } else if (root.right == null) {
            return getHeight(root.left) + 1;
        } else {
            return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
        }
    }

    // bottom-up approach
    public boolean isBalanced1(TreeNode root) {
        // cc
        if (root == null) {
            return true;
        }

        return getHeight1(root) != -1;
    }

    private int getHeight1(TreeNode root) {
        // cc & base case
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight1(root.left);
        int rightHeight = getHeight1(root.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
