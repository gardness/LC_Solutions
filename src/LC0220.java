import java.util.*;

public class LC0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashMap<Long, Integer> map = new HashMap<>();                                       //  Use Long to enable us to search in the map values that exceed the upper limit of Integer

        for (int i = 0; i < nums.length; i++) {
            for (long value = (long) nums[i] - t; value <= (long) nums[i] + t; value++) {          //  Cast nums[i] to long to make sure the sum doesn't overflow
                if (map.containsKey(value) && (i - map.get(value) <= k)) {
                    return true;
                }
            }

            map.put((long) nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        LC0220 solution = new LC0220();

//        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2147483640,2147483641}, 1, 100));
//        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{-2147483640,-2147483641}, 1, 100));
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{2147483647, -1, 2147483647}, 1, 2147483647));

    }
}
