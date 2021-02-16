import java.util.*;

public class LC0136 {
    // Bitwise Operation
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }

    // Binary Search
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        int len = nums.length;

        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;

            if ((mid - l) % 2 == 1) {   // Odd number of elements on the left side
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {                    // Even number of elements on the left side
                if (mid + 1 < len && nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else {
                    r = mid;
                }
            }
        }

        if (r == len - 1 || (nums[r] != nums[r + 1])) {
            return nums[r];
        }

        return nums[l];
    }

    // Binary Search
    public int singleNumber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        int len = nums.length;

        Arrays.sort(nums);

        while (l < r) {
            int mid = (r - l) / 2 + l;

            if (mid % 2 == 1) {   // Odd number of elements on the left side
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {                    // Even number of elements on the left side
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else {
                    r = mid;
                }
            }
        }

        return nums[l];
    }


    public static void main(String[] args) {

    }
}
