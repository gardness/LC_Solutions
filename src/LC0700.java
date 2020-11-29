import ADT.TreeNode;

public class LC0700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // cc
        if (root == null) {
            return null;
        }

        TreeNode cur = root;

        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return null;
    }
}
