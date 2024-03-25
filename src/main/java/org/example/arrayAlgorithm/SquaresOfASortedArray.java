package org.example.arrayAlgorithm;

/**
 * 给一个有序数组，返回该数组的平方，要求返回的数组也是有序的
 */
public class SquaresOfASortedArray {
    public static int[] squaresOfASortedArray(int[] nums) {
        int point1 = 0;
        int point2 = nums.length - 1;
        int[] squareNums = new int[nums.length];
        for (int point3 = nums.length - 1; point3 >= 0; point3--) {
            if (Math.abs(nums[point1]) < Math.abs(nums[point2])) {
                squareNums[point3] = nums[point2] * nums[point2];
                point2--;
            } else {
                squareNums[point3] = nums[point1] * nums[point1];
                point1++;
            }
        }
        return squareNums;
    }

    /**
     * 标准答案
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) { //运用的时左下标小于右下标进行循环判断
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] squareNums = squaresOfASortedArray(nums);
        for (int i = 0; i < squareNums.length; i++) {
            System.out.print(squareNums[i]+" ");
        }

    }
}
