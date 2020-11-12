import java.util.Arrays;
import java.util.List;

public class LC0274 {
    public int hIndex(int[] citations) {
        // Corner Case
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int hIndex= citations.length;
        int i = 0;

        while (i < citations.length && citations[i] < hIndex) {
            hIndex--;
            i++;
        }

        return hIndex;
    }

    // Counting sort
    public int hIndex2(int[] citations){
        // Corner Case
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int[] cnt = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length) {
                cnt[citations.length]++;
            } else {
                cnt[citations[i]]++;
            }
        }

        int j = cnt.length - 1;

        while (j >= 0) {
            if (cnt[j] >= j + 1) {
                break;
            }

            j--;
        }

        return j;
    }

    public int[][] createTriangle (int n) {
        // cc
        if (n < 0) {
            return null;
        }

        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[0] = new int[n - i - 1];
        }

        return arr;
    }

    public static void main(String[] args) {
        LC0274 solution = new LC0274();
        solution.hIndex2(new int[]{3,0,6,1,5});
    }
}
