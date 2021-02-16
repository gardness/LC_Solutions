import java.util.*;

public class LC0349 {

    // S1 : First sort, then add the first element if there're duplicates
    // [4,5,9]
    // [4,4,8,9,9]
    // Time Complexity : O(mlogm + nlogn + m + n)
    // Space Complexity : O(max{m,n})
    public int[] intersection(int[] nums1, int[] nums2) {
        // cc
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new LinkedList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;

                while (i < nums1.length && nums1[i] == nums1[i - 1]) {
                    i++;
                }

                while (j < nums2.length && nums2[j] == nums2[j - 1]) {
                    j++;
                }
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        int[] res = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }


    // S2 : sorted + binary search
    // Time Complexity : O(mlogm + nlogn + mlogn)
    // Space Complexity : O(max{m,n})
    public int[] intersection1(int[] nums1, int[] nums2) {
        // cc
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new LinkedList<>();

        int i = 0;
        while (i < nums1.length) {
            if (binarySearch(nums2, nums1[i])) {
                list.add(nums1[i++]);

                while (i < nums1.length && nums1[i - 1] == nums1[i]) {
                    i++;
                }
            } else {
                i++;
            }
        }

        int[] res = new int[list.size()];

        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }

        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }


    // S3 : HashSet
    // Time Complexity : O(m + n)
    // Space Complexity : O(m + n + k)
    public int[] intersection2(int[] nums1, int[] nums2) {
        // cc
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        HashSet<Integer> ans = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                ans.add(nums2[i]);
            }
        }

        int[] res = new int[ans.size()];
        Integer[] nums = ans.toArray(new Integer[0]);


        for (int i = 0; i < nums. length; i++) {
            res[i] = nums[i];
        }

        return res;
    }
}
