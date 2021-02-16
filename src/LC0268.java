import java.util.*;

public class LC0268 {
    // S1: Sort, one pass
    public int missingNumber(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    // S3: Sort, binary search
    //  0 1 2 3 4 5 6 7 8 9
    //  0 1 3 4 5
    public int missingNumber1(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(nums);

        if (nums[0] != 0) {
            return 0;
        }

        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid - 1] != nums[mid] - 1) {
                return nums[mid] - 1;
            } else if (nums[mid] == mid) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[l - 1] != nums[l] - 1) {
            return nums[l] - 1;
        } else {
            return nums[r] - 1;
        }
    }

    // S4: HashMap, two pass
    //  0 1 2 3 4 5 6 7 8 9
    //  0 1 3 4 5
    public int missingNumber2(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }

        return -1;
    }

    // S5: HashSet, two pass
    //  0 1 2 3 4 5 6 7 8 9
    //  0 1 3 4 5
    public int missingNumber3(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    // S6: Math
    //  0 1 2 3 4 5 6 7 8 9
    //  0 1 3 4 5
    public int missingNumber4(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int sum = nums.length * (1 + nums.length) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }


    // S7: Bit Manipulation
    public int missingNumber5(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int res = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            res ^= i;
        }

        for (int num : nums) {
            res ^= num;
        }

        return res;
    }
}
