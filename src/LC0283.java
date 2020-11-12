public class LC0283 {
    // [12, 1, 3, 0, 0]
    //            l
    //         r
    public void moveZeroes(int[] nums) {
        // cc
        if (nums == null || nums.length < 2) {
            return;
        }

        int l = 0;
        for (int r = l; r < nums.length; r++) {
            if (nums[r] != 0) {
                swap(nums, l++, r);
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
