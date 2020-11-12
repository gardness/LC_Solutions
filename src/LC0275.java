public class LC0275 {
    // 0, 1, 2, 4, 5, 6
    //          l
    //       r
    //         mid
    public int hIndex(int[] citations) {
        // Corner Case
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return n - l;
    }
}
