public class LC0278 {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (!isBadVersion(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return isBadVersion(l) ? l : r;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
