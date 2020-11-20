import ADT.TreeNode;

public class LC0270 {

    final double DELTA = 0.0001;

    public int closestValue(TreeNode root, double target) {
        // cc
        if (root == null) {
            throw new IllegalArgumentException();
        }

        TreeNode min = root;
        TreeNode cur = root;

        while (cur != null) {
            double diff = Math.abs(cur.val - target);

            if (diff < DELTA) {
                return root.val;
            } else if (diff < Math.abs(min.val - target)) {
                min = cur;
            }

            if (root.val < target) {
                cur = cur.right;
            } else if (root.val > target) {
                cur = cur.left;
            }
        }

        return min.val;
    }
}
