package org.example.arrayAlgorithm;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class minSubArrayLen {
    /**
     * 暴力解法
     *核心思路是两个循环遍历数组
     * j是末尾的数，i是开头的数，遍历i和j之间的数组和，i++直到j，j--
     * @param s
     * @param nums
     * @return
     */
    public static int volientMethod(int s, int[] nums) {
        int j = nums.length - 1;
        int k = 0;
        int t = 1000;
        for (; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                int m = 0;
                for (int p = i; p <= j; p++) {
                    m += nums[p];
                }
                    if (m >= s) {
                        k = j - i + 1;
                        if (t > k) {
                            t = k;
                        }
                    }else if (j == nums.length - 1 && i == 0) {
                               return 0;
                    }
                }
            }
        return t;
    }

    /**
     * 滑动窗口法
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s){
                int subL = j - i + 1;
                result = Math.min(subL, result);
                sum -= nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {
        int s = 5;
        int[] nums = {1,2,3,4,5};
        System.out.println(volientMethod(s,nums));
        System.out.println(minSubArrayLen(s,nums));
    }

}
