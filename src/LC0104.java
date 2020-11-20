import ADT.*;

public class LC0104 {
    public int maxDepth(TreeNode root) {
        // cc & base case
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
