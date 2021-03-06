import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC0215 {
    // [3,2,1,5,6,4] and k = 2
    public int findKthLargest(int[] nums, int k) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        for (int i : nums) {
            pq.offer(i);

            if (pq.size() > nums.length - k + 1) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    // [3,2,1,5,6,4] and k = 2
    public int findKthLargest1(int[] nums, int k) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        return quickSort(nums, k, 0, nums.length - 1);
    }

    private int quickSort(int[] nums, int k, int left, int right) {
        // Base Case
        if (left >= right) {
            return nums[left];
        }

        int pos = partition1(nums, left, right);
        int n = nums.length;

        if (pos == n - k) {
            return nums[pos];
        } else if (pos < n - k) {
            return quickSort(nums, k,pos + 1, right);
        } else {
            return quickSort(nums, k, 0, pos - 1);
        }
    }

    // [3, 2, 1, 5, 6, 4] and k = 2
    //                   l
    //                 r
    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[pivot] > nums[l]) {
                l++;
            } else if (nums[pivot] <= nums[r]) {
                r--;
            } else {
                swap(nums, l++, r--);
            }
        }

        swap(nums, pivot, r);
        return r;
    }

    // [5, 2, 3, 7, 6, 4] and k = 2
    //           l
    //              r
    //                 p
    private int partition1(int[] nums, int left, int right) {
        int pivot = right;
        int l = left;

        for (int r = left; r < right; r++) {
            if (nums[r] <= pivot) {
                swap(nums, l++, r);
            }
        }

        swap(nums, l, right);

        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }


    // MinHeap approach
    // [5, 2, 3, 7, 6, 4] and k = 2
    // Time complexity : O(klogk + (n-k)logk)
    // Space complexity :
    public int findKthLargest2(int[] nums, int k) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, ((a, b) -> (a - b)));

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.poll();
    }


    // MinHeap
    // Time Complexity : O(k + (n - k) * logk)
    // Space Complexity :
    public int findKthLargest3(int[] nums, int k) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.poll();
    }

    // [1,2,2,3,3,4,5,5,6] and k = 4
    //
    //
    public int findKthLargest4(int[] nums, int k) {
        // cc
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        // base case
        if (left == right) {
            return nums[left];
        }

        int i = partition2(nums, left, right);
        int len = nums.length;

        if (len - i == k) {
            return nums[i];
        } else if (len - i > k) {
            return quickSelect(nums, i + 1, right, k);
        } else {
            return quickSelect(nums, left, i - 1, k);
        }
    }

    private int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];

        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] < pivot) {
                l++;
            } else if (nums[r] >= pivot) {
                r--;
            } else {
                swap1(nums, l, r);
            }
        }

        swap1(nums, left, r);

        return r;
    }

    private void swap1(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


//    public int findKthLargest5(int[] nums, int k) {
//        // cc
//        if (nums == null || nums.length == 0) {
//            throw new IllegalArgumentException();
//        }
//
//        TreeMap<>
//    }

    public static void main(String[] args) {
        LC0215 solution = new LC0215();
        solution.findKthLargest4(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }


}
