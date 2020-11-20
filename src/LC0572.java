import ADT.*;

public class LC0572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // base case
        if (s == null) {
            return false;
        }

        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }

        if (t == null || s == null || t.val != s.val) {
            return false;
        }

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    // follow up : determine if t resembles a part of s
    public boolean isSame1(TreeNode s, TreeNode t) {
        if (t == null && s == null || t == null && s != null) {
            return true;
        }

        if (t != null && s == null || t.val != s.val) {
            return false;
        }

        return isSame1(s.left, t.left) && isSame1(s.right, t.right);
    }
}
