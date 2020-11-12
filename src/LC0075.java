public class LC0075 {
    // [2,0,2,1,1,0]
    public void sortColors(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] cnt = new int[3];

        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }

        int j = 0;

        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
}
