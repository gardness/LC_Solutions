import ADT.TreeNode;

public class SearchRangeinBST {
    // Time complexity : O(n)
    // Space complexity : O(logn)
    public void SearchRangeinBST(TreeNode root, int k1, int k2) {
        // cc
        if (root == null) {
            return;
        }

        if (root.val > k1) {
            SearchRangeinBST(root.left, k1, k2);
        }

        if (root.val >= k1 && root.val <= k2) {
            System.out.print(root.val + " ");
        }

        if (root.val < k2) {
            SearchRangeinBST(root.right, k1, k2);
        }
    }
}
