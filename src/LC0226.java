import ADT.*;

public class LC0226 {
    // bottom-top approach
    public TreeNode invertTree(TreeNode root) {
        // cc
        if (root == null) {
            return null;
        }

        TreeNode leftChild = invertTree(root.left);
        TreeNode rightChild = invertTree(root.right);

        root.left = rightChild;
        root.right = leftChild;

        return root;
    }

    // top-down approach
    public TreeNode invertTree1(TreeNode root) {
        // cc
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }
}
