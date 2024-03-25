package org.example.arrayAlgorithm;

public class DichotomicMethodTest {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 运用二分法搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1,
     * 搜索区间为左闭右开
     *
     * @param nums target
     * @return
     */
    public static int DichotomicMethod(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        while (nums[mid] != target) {
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
            if (left == right) {
                return -1;
            } else {
                mid = (left + right) / 2;
            }
        }
        return mid;
    }

    /**
     * 标答
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }

    /**
     * 左闭右闭
     * @return
     */
    public static int DichotomicMethod1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (nums[middle] > target) {
                right = middle - 1;
            }if (nums[middle] < target) {
                left = middle + 1;
            }if (nums[middle] == target){
                return middle;
            }
        }
        return -1;
    }

    /**
     * 标达
     * @param
     */
    public int search1(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 3, 5, 9, 12};
        int target = 100;
        System.out.println(DichotomicMethod1(nums, target));
    }
}
