public class LC0045 {
    // Greedy
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int prevMax = i;
        int curMax = i;
        int times = 0;

        while (i < nums.length) {
            if (i > prevMax) {
                prevMax = curMax;
                times++;
            }

            if (i + nums[i] > curMax) {
                curMax = i + nums[i];

                if (curMax > nums.length - 2) {
                    break;
                }
            }

            i++;
        }

        return ++times;
    }
}
